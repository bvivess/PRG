package ACT6_3;

/**
 *
 * @author winadmin
 */
public class Main {
    
    public static void main(String args[]) {

        Elevator elevator = new Elevator();

        // Algunes d'aquestes operacions no són possibles segons la seqüència establerta
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
