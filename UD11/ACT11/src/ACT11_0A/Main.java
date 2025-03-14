package ACT11_0A;

public class Main {

    public static void main(String[] args) {
        new Persona("Bernat", 23){
            
            @Override
            public void saluda(){ 
                System.out.println("Hola, sóc " + super.getNom() + " una persona anònima");
            }
            
        }.saluda();
    }
    
}
