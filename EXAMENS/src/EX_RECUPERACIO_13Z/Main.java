package EX_RECUPERACIO_13Z;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] arxius = {"c:\\temp\\categories_tab.txt", "c:\\temp\\product_information.txt"};
        List<Category> categories = new ArrayList<>();
        List<ProductInformation> productInformations = new ArrayList<>();
        try {
            arxiuAObjectes(arxius, categories, productInformations);
            mostrarObjectes(categories, productInformations);
            objectesABaseDades("c:\\temp\\dbase.con\\", categories, productInformations);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
    private static void arxiuAObjectes(String[] arxius, List<Category> categories, List<ProductInformation> productInformations) throws FileNotFoundException, IOException {
        categoriesAObjectes(arxius[0],categories);
        productInformationAObjectes(arxius[1],productInformations);
    }
    
    private static void categoriesAObjectes(String nomArxiu, List<Category> categories) throws FileNotFoundException, IOException{
        int categoryId=0;
        String categoryName="";
        String categoryDescription="";
        int parentCategoryId=0;
        
        try ( BufferedReader bufInput = new BufferedReader(new FileReader(nomArxiu))) {
            String linia = linia = bufInput.readLine();
            while ((linia = bufInput.readLine()) != null) {
                if (!linia.startsWith("-"))
                    try {
                        String[] parts = linia.split("\\]\\s\\[");
                        String clau = parts[0].trim().replace("[","");
                        String valor = parts[1].trim().replace("]","");

                        switch (clau) {
                            case "category_id" -> categoryId = Integer.parseInt(valor);
                            case "category_name" -> categoryName = valor;
                            case "category_description" -> categoryDescription = valor;
                            case "parent_category_id" -> parentCategoryId = (valor.equals("null")? 0: Integer.parseInt(valor));
                            default -> System.err.println("Clau no vàlida: " + clau);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        // En cas de '#', l'split no funciona
                        // No fer res
                    }

                else {
                    Category category = new Category(categoryId, categoryName, categoryDescription, parentCategoryId);
                    categories.add(category);
                }
            }
        } catch (FileNotFoundException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static void productInformationAObjectes(String nomArxiu, List<ProductInformation> productInformations) throws FileNotFoundException, IOException{
        int productId=0;
        String productName="";
        String productDescription="";
        int categoryId=0;
        String productStatus="";
        
        try ( BufferedReader bufInput = new BufferedReader(new FileReader(nomArxiu))) {
            String linia = linia = bufInput.readLine();
            while ((linia = bufInput.readLine()) != null) {
                if (!linia.startsWith("-"))
                    try {
                        String[] parts = linia.split("\\] \\[");
                        String clau = parts[0].trim().replace("[","");
                        String valor = parts[1].trim().replace("]","");
                        
                        switch (clau) {
                            case "product_id" -> productId = Integer.parseInt(valor);
                            case "product_name" -> productName = valor;
                            case "product_description" -> productDescription = valor;
                            case "category_id" -> categoryId = (valor.equals("null") ? 0 : Integer.parseInt(valor));
                            case "product_status" -> productStatus = valor;
                            default -> System.err.println("Clau no vàlida: " + clau);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        // En cas de '#', l'split no funciona
                        // No fer res
                    }

                else {
                    ProductInformation productInformation = new ProductInformation(productId, productName, productDescription, categoryId, productStatus);
                    productInformations.add(productInformation);
                }
            }
        } catch (FileNotFoundException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }    
    
    private static void mostrarObjectes(List<Category> categories, List<ProductInformation> productInformations) {
        for (Category r : categories) {
            System.out.println(r.toString());
        }
        
        System.out.println("--------------------------------------------");
        
        for (ProductInformation c : productInformations)
            System.out.println(c.toString());
    }

    private static void objectesABaseDades(String nomArxiu, List<Category> categories, List<ProductInformation> productInformations) throws SQLException, IOException {
        
        System.out.println(nomArxiu);
        try ( Connection connexio = connectaDB(nomArxiu) ) {
            System.out.println("Connexió establerta.");
 
            connexio.setAutoCommit(false);
            for (Category c : categories)
                insertCategory(connexio, c);
        
            for (ProductInformation p : productInformations)
                insertProductInformation(connexio, p);
            
            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static Connection connectaDB(String filename) throws SQLException, IOException {
        String seccio = "";
        String server = "";
        String bdades = "";
        String usuari = "";
        String passwd = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[server]"))
                    seccio = "server";
                else if (line.startsWith("[database]"))
                    seccio = "database";
                else if (line.startsWith("["))
                    seccio = "";
                else {
                    try {
                        String[] parts = line.split(":",2);
                        String clau = parts[0].trim();
                        String valor = parts[1].trim().replace("\"","");
                        
                        if (seccio.equals("server"))
                            switch (clau) {
                                case "name" -> server = valor;
                                default -> System.err.println("Clau no vàlida: " + clau);
                            }
                        else if (seccio.equals("database"))
                            switch (clau) {
                                case "name" -> bdades = valor;
                                case "user" -> usuari = valor;
                                case "password" -> passwd = valor;
                                default -> System.err.println("Clau no vàlida: " + clau);
                            }
                    } catch (IndexOutOfBoundsException e) {
                        // En cas de '#', l'split no funciona
                        // No fer res
                    }
                }
            }
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection(server + bdades, usuari, passwd);
    }
    
    private static void insertCategory(Connection connexio, Category c) throws SQLException, IOException {
        Statement statement = connexio.createStatement();
        String sql="";
        try {
            sql = "INSERT INTO categories_tab (CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, PARENT_CATEGORY_ID)" +  
                  "VALUES (" + 
                    c.getCategoryId() + "," +
                    "\"" + c.getCategoryName() + "\"" + "," +
                    "\"" + c.getCategoryDescription() + "\"" + "," +
                    (c.getParentCategoryId() == 0 ? "null" :  c.getParentCategoryId()) + ")";
            statement.executeUpdate(sql);

            connexio.commit();
        } catch (SQLException e) {
            connexio.rollback();
            System.out.println("Error en inserción: " + e);
        }
    }
    
    private static void insertProductInformation(Connection connexio, ProductInformation p) throws SQLException, IOException {
    Statement statement = connexio.createStatement();
    String sql="";
    try {
        sql = "INSERT INTO product_information (PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, CATEGORY_ID, PRODUCT_STATUS)" +  
              "VALUES (" + 
                p.getProductId() + "," +
                "\"" + p.getProductName() + "\"" + "," +
                "\"" + p.getProductDescription() + "\"" + "," +
                p.getCategoryId() + "," +
                "\"" + p.getProductStatus() + "\"" + ")";
        statement.executeUpdate(sql);

        connexio.commit();
    } catch (SQLException e) {
        connexio.rollback();
        System.out.println("Error en inserción: " + e + sql);
    }
}
    
}
