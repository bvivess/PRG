package ex_final;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorCentre centre = new GestorCentre();
        Scanner sc = new Scanner(System.in);

        boolean sortir = false;
        while (!sortir) {
            System.out.println("\n1. Afegir usuari\n2. Mostrar usuaris\n3. Afegir activitat\n4. Fer reserva\n5. Mostrar activitats\n6. Mostrar reserves\n7. Guardar\n8. Carregar\n0. Sortir");
            switch (sc.nextLine()) {
                case "1" -> {
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Correu: ");
                    String correu = sc.nextLine();
                    System.out.print("Edat: ");
                    int edat = Integer.parseInt(sc.nextLine());
                    centre.afegirUsuari(new Usuari(nom, correu, edat));
                }
                case "2" -> centre.mostrarUsuaris();
                case "3" -> {
                    System.out.print("Codi: ");
                    String codi = sc.nextLine();
                    System.out.print("Descripció: ");
                    String desc = sc.nextLine();
                    System.out.print("Durada: ");
                    int durada = Integer.parseInt(sc.nextLine());
                    System.out.print("Dificultat (BAIXA, MITJANA, ALTA): ");
                    Dificultat d = Dificultat.valueOf(sc.nextLine().toUpperCase());
                    centre.afegirActivitat(new Activitat(codi, desc, durada, d));
                }
                case "4" -> {
                    System.out.print("Correu usuari: ");
                    String correu = sc.nextLine();
                    System.out.print("Codi activitat: ");
                    String codi = sc.nextLine();
                    System.out.print("Data (YYYY-MM-DD): ");
                    LocalDate data = LocalDate.parse(sc.nextLine());
                    if (!centre.afegirReserva(correu, codi, data))
                        System.out.println("Error: reserva no creada.");
                }
                case "5" -> centre.getActivitats().values().forEach(System.out::println);
                case "6" -> centre.getReserves().forEach(System.out::println);
                case "7" -> {
                    try {
                        GestorFitxers.guardar(centre, "centre.ser");
                        System.out.println("Dades guardades.");
                    } catch (Exception e) {
                        System.out.println("Error al guardar: " + e.getMessage());
                    }
                }
                case "8" -> {
                    try {
                        centre = GestorFitxers.carregar("centre.ser");
                        System.out.println("Dades carregades.");
                    } catch (Exception e) {
                        System.out.println("Error al carregar: " + e.getMessage());
                    }
                }
                case "0" -> sortir = true;
            }
        }
    }
}

