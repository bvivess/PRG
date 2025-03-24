package ACT12_0C;

public class Main {

    public static void main(String[] args) {
        new Persona(){
            
            @Override
            public void saluda(){ 
                System.out.println("Hola, sóc una persona anònima");
            }
            
        }.saluda();
    }
    
}
