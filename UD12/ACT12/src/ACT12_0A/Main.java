package ACT12_0A;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        // Classe anÃ²nima a partir de Classe simple
        new Persona("Bernat", 23) {  }.saluda();
=======
        // Classe anónima a partir de Classe simple
        new Persona("Bernat", 23) {
            
            @Override
            public void saluda(){ 
                System.out.println("Hola, sóc " + super.getNom() + ", una persona anónima");
            }
            
        }.saluda();
>>>>>>> 327767d1d556477d9311605e1c04b7d7db862309
    }
    
}
