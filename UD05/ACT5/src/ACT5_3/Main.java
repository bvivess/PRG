package ACT5_3;

/**
 *
 * @author winadmin
 */
public class Main {
    
    public static void main(String args[]) {

        Elevator elevator = new Elevator();

        // Algunes d'aquestes operacions no s�n possibles segons la seq��ncia establerta
        elevator.openDoor();  // pis=1
        elevator.closeDoor();
        elevator.goDown();  // xxx
        elevator.goUp();  // pis=2
        elevator.goUp();  // pis=3
        elevator.openDoor();
        elevator.closeDoor();
        elevator.goDown(); // pis=2
        elevator.openDoor();
        elevator.goDown();  // xxx
        elevator.closeDoor();
        elevator.goDown();  // pis=1
        elevator.goDown();  // xxx

    }
}
