package ACT12_0A;

public class Main {

    public static void main(String[] args) {
        // Classe anÃ²nima a partir de Classe simple
        new Persona("Bernat", 23) {  }.saluda();
        // Classe anónima a partir de Classe simple
        new Persona("Bernat", 23) {
            
            @Override
            public void saluda(){ 
                System.out.println("Hola, sóc " + super.getNom() + ", una persona anónima");
            }
            
        }.saluda();
    }
    
}
