package EX_RECUPERACIO_13C;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<InstruccioDDL> instruccionsDDL = new ArrayList<>();
        try {
            arxiuAObjectes("c:\\temp\\DDL.sql\\", instruccionsDDL);
            mostrarObjectes(instruccionsDDL);
            objectesABaseDades("c:\\temp\\dbase.con\\", instruccionsDDL);
        } catch (IOException | SQLException e) {
            System.out.println("Exception: " + e);
        }
    }
    
    private static void arxiuAObjectes(String nomArxiu, List<InstruccioDDL> instruccionsDDL) throws FileNotFoundException, IOException{
        String text = "";
        int i = 0;
        
        try ( BufferedReader bufferInput = new BufferedReader(new FileReader(nomArxiu))) {
            String linia;
            while ((linia = bufferInput.readLine()) != null) {
                if (!linia.startsWith("#"))
                        text += linia;  // acumula en 'text' les parts de la instrucció
                else {
                    i++;
                    InstruccioDDL instruccio = new InstruccioDDL(i, text.replace(";", ""));
                    instruccionsDDL.add(instruccio);
                    text = "";
                }
            }
            
            // Darrera instrucció
            i++;
            InstruccioDDL instruccio = new InstruccioDDL(i, text.replace(";", ""));
            instruccionsDDL.add(instruccio);
        } catch (FileNotFoundException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }

    private static void mostrarObjectes(List<InstruccioDDL> instruccionsDDL) {
        for (InstruccioDDL i : instruccionsDDL)
            System.out.println(i.toString());
    }
    
    private static void objectesABaseDades(String nomArxiu, List<InstruccioDDL> instruccionsDDL) throws SQLException, IOException {
        
        System.out.println(nomArxiu);
        try ( Connection connexio = connectaDB(nomArxiu) ) {
            System.out.println("Connexió establerta.");
 
            connexio.setAutoCommit(false);
            for (InstruccioDDL i : instruccionsDDL)
                creaTaula(connexio, i);
            
            System.out.println("Connexió tancada.");
        } catch (SQLException | IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
        // Es propaga l'excepció al mètode anterior
        
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
    
    private static void creaTaula(Connection connexio, InstruccioDDL instruccio) throws SQLException, IOException {
        Statement statement = connexio.createStatement();
        String sql;
        try {
            sql = instruccio.getTexte();
            statement.executeUpdate(sql);
            
            System.out.println("Executat OK: " + sql);

            connexio.commit();
        } catch (SQLException e) {
            connexio.rollback();
            System.out.println("Error en SQL: " + e);
        }
    }
 
}
