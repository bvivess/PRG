package ACT6_3;

/**
 *
 * @author winadmin
 */
public class Elevator {
    
    private boolean doorOpen;
    private int currentFloor;
    private static int TOP_FLOOR;
    private static int BOTTOM_FLOOR;

    public Elevator(boolean doorOpen, int currentFloor) {
        this.doorOpen = doorOpen;
        this.currentFloor = currentFloor;
    }

    static {
        TOP_FLOOR=5;
        BOTTOM_FLOOR=1;
    }
    
    // M�todes espec�fics
    // modifica 'doorOpen'=true
    public void openDoor() {
        System.out.println("...Obrint la porta");
        setDoorOpen(true);
    }
    
    // modifica 'doorOpen'=false
    public void closeDoor() {
        System.out.println("...Tancant la porta");
        setDoorOpen(false);
    }
    
    // augmenta 'currentFloor' si ascensor no est� al darrer pis i la porta est� tancada
    public void goUp() {
        System.out.println("...Anant a d'alt");
        if (!getDoorOpen()) {
            if (getCurrentFloor() < TOP_FLOOR) {
                setCurrentFloor(getCurrentFloor() + 1);
            } else {
                throw new IllegalArgumentException("No �s possible pujar, ja en el pis de d'alt");
            }
        } else {
            throw new IllegalArgumentException("Porta oberta, cal tancar-la");
        }
        System.out.println("\tPis actual: " + currentFloor);
    }
    
    // disminueix 'currentFloor' si ascensor no est� al primer pis i la porta est� tancada
    public void goDown() {
        System.out.println("...Anant abaix");
        if (!getDoorOpen()) {
            if (getCurrentFloor() > BOTTOM_FLOOR) {
                setCurrentFloor(getCurrentFloor() - 1);
            } else {
                throw new IllegalArgumentException("No �s possible baixar, ja en el pis de baix");
            }
        } else {
            throw new IllegalArgumentException("Porta oberta, cal tancar-la");
        }
        System.out.println("\tPis actual: " + currentFloor);
    }

    public boolean getDoorOpen() {
        return doorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    
    
}
