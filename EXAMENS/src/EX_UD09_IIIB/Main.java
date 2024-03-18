package EX_UD09_IIIB;

import java.util.ArrayList;

public class Main {

    static final int HABITACIO_SIMPLE = 1;
    static final int HABITACIO_DOBLE = 2;
    
    public static void main(String[] args) {
        // Creació de les habitacions amb disponibilitat inicial i preu
        Hotel hotel = new Hotel(new Habitacio[] { new HabitacioSimple(101, 2, false, 50.0),
                                                  new HabitacioSimple(102, 2, false, 50.0),
                                                  new HabitacioSimple(103, 3, false, 60.0),
                                                  new HabitacioDoble(201, 4, false, 80.0),
                                                  new HabitacioDoble(202, 4, false, 80.0),
                                                  new HabitacioDoble(203, 5, false, 100.0),
                                                  new HabitacioDoble(301, 6, false, 150.0)
                                                }
                                );
        // Persona
        Persona persona = new Persona("Joana Lopez Arteche",36);
        
        // Creació del client
        Reserva reserva = new Reserva(1, persona, new ArrayList<Habitacio>());
        
        // Reserva d'habitacions 
        System.out.println(hotel.toString());
        if (reserva.afegeixHabitacio(hotel, 3))
            System.out.println("Habitació ID=" + reserva.getHabitacions().get(reserva.getHabitacions().size()-1).getIdHabitacio() + " reservada");
        else
            System.out.println("Habitación no reservada");
        
        if (reserva.afegeixHabitacio(hotel, 100))
            System.out.println("Habitació ID=" + reserva.getHabitacions().get(reserva.getHabitacions().size()-1).getIdHabitacio() + " reservada");
        else
            System.out.println("Habitación no reservada");

        // Mostra dades
        System.out.println(reserva.toString() + "\nPreu Total: " + reserva.calculaPreu());
        System.out.println(hotel.toString());
    }
}

