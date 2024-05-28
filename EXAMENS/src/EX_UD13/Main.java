package EX_UD13;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Map<Integer, Region> regions = new HashMap<>();
        Map<String, Country> countries = new HashMap<>();
        try {
            arxiuAObjectes("c:\\temp\\countries.txt", regions, countries);
            mostrarObjectes(regions, countries);
            objectesABaseDades("c:\\temp\\dbase.con\\", regions, countries);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
    private static void arxiuAObjectes(String nomArxiu, Map<Integer, Region> regions, Map<String, Country> countries) throws FileNotFoundException, IOException{
        File nomArxiu2 = new File(nomArxiu); 
        try ( BufferedReader bufInput = new BufferedReader(new FileReader(nomArxiu))) {
            String linia = linia = bufInput.readLine(); 
            linia = linia = bufInput.readLine();
            while ((linia = bufInput.readLine()) != null) {
                String[] parts = linia.split("\\|");
                String countryId = parts[0].trim();
                String countryName = parts[1].trim();
                int regionId = Integer.parseInt(parts[2].trim());
                String regionName = parts[3].trim();
                
                Region region = new Region(regionId, regionName);
                Country country = new Country(countryId, countryName, regionId);

                //if (!regions.containsKey(regionId))
                    regions.put(regionId, region);
                
                //if (!countries.containsKey(countryId))
                    countries.put(countryId, country);
            }
        } catch (FileNotFoundException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static void mostrarObjectes(Map<Integer, Region> regions, Map<String, Country> countries) {
        for (Region r : regions.values()) {
            System.out.println(r.toString());
        }
        
        System.out.println("--------------------------------------------");
        
        for (Country c : countries.values())
            System.out.println(c.toString());
    }
    
    private static void objectesABaseDades(String nomArxiu, Map<Integer, Region> regions, Map<String, Country> countries) throws SQLException, IOException {
        try ( Connection connexio = connectaDB(nomArxiu) ) {
            System.out.println("Connexió establerta.");
 
            connexio.setAutoCommit(false);
            for (Region r : regions.values())
                insertRegion(connexio, r);
        
            for (Country c : countries.values())
                insertCountry(connexio, c);
            
            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static Connection connectaDB(String filename) throws SQLException, IOException {
        boolean llegeix = false;
        String servidor = "";
        String bdades = "";
        String usuari = "";
        String passwd = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("## MySQL"))
                    llegeix = true;
                else if (line.startsWith("##"))
                    llegeix = false;
                
                if (llegeix)
                    try {
                        String[] parts = line.split("=");
                        String clau = parts[0].trim();
                        String valor = parts[1].trim();

                        switch (clau) {
                            case "SERVER" -> servidor = valor;
                            case "DBASE" -> bdades = valor;
                            case "USER" -> usuari = valor;
                            case "PASSWD" -> passwd = valor;
                            default -> System.err.println("Clau no vàlida: " + clau);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        // En cas de '#', l'split no funciona
                        // No fer res
                    }
            }
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection(servidor + bdades, usuari, passwd);
    }
    
    private static void insertRegion(Connection connexio, Region r) throws SQLException, IOException {
        try {
            // Comprovar integritat referencial amb 'regions'
            if (!SQLCheckPK(connexio, "regions", Integer.toString(r.getRegionId())))
                SQLInsert(connexio, "regions", r.getRegionId().toString(), r.getRegionName());

            connexio.commit();
        } catch (SQLException e) {
            connexio.rollback();
            throw e;
        }
    }
    
    private static void insertCountry(Connection connexio, Country c) throws SQLException {
        try {
            // Comprovar integritat referencial amb 'countries'
            if (!SQLCheckPK(connexio, "countries", c.getCountryId()))
                SQLInsert(connexio, "countries", c.getCountryId(), c.getCountryName(), Integer.toString(c.getRegionId()));
            
            connexio.commit();
        } catch (SQLException e) {
            connexio.rollback();
            throw e;
        }
    }
    
    private static boolean SQLCheckPK(Connection connexio, String taula, String primaryKey) throws SQLException  {
        Statement statement = connexio.createStatement();
        String sql="";

        try {
            if (taula.equals("regions"))
                sql = "SELECT '1' FROM regions WHERE region_id = " + primaryKey;
            else if (taula.equals("countries"))
                sql = "SELECT '1' FROM countries WHERE country_id = '" + primaryKey + "'";
            
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.next(); // si existeix al manco 1 fila ?

        } catch (SQLException e) {
            throw e;
        } 
    }
    
    private static void SQLInsert(Connection connexio, String table, String ... valors) throws SQLException  {
        Statement statement = connexio.createStatement();
        String sql="";

        try {
            if (table.equals("regions"))
                sql = "INSERT INTO regions (REGION_ID, REGION_NAME) VALUES (" + valors[0] + ", '" + valors[1] +"')";
            else if (table.equals("countries"))
                sql = "INSERT INTO countries (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES (" + valors[0] + ",'" + valors[1] + "'," + valors[2] + ")";
  
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        } 

    }
    
}
