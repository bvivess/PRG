package ACT5_3;

/**
 *
 * @author winadmin
 */
public class Elevator {
    
    public boolean doorOpen = false;
    public int currentFloor = 1;
    public static int topFloor = 5;
    public static int bottomFloor = 1;
    
    // M�todes espec�fics
    // modifica 'doorOpen'=true
    public void openDoor() {
        System.out.println("...Obrint la porta");
        doorOpen = true;
    }
    
    // modifica 'doorOpen'=false
    public void closeDoor() {
        System.out.println("...Tancant la porta");
        doorOpen = false;
    }
    
    // augmenta 'currentFloor' si ascensor no est� al darrer pis i la porta est� tancada
    public void goUp() {
        System.out.println("...Anant a d'alt");
        if (!doorOpen) {
            if (currentFloor < topFloor) {
                currentFloor++;
            } else {
                System.err.println("No �s possible pujar, ja en el pis de d'alt");
            }
        } else {
            System.err.println("Porta oberta, cal tancar-la");
        }
        System.out.println("\tPis actual: " + currentFloor);
    }
    
    // disminueix 'currentFloor' si ascensor no est� al primer pis i la porta est� tancada
    public void goDown() {
        System.out.println("...Anant abaix");
        if (!doorOpen) {
            if (currentFloor > bottomFloor) {
                currentFloor--;
            } else {
                System.err.println("No �s possible baixar, ja en el pis de baix");
            }
        } else {
            System.err.println("Porta oberta, cal tancar-la");
        }
        System.out.println("\tPis actual: " + currentFloor);
    }
}
