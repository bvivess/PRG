import java.util.Arrays;
public class Prova {
    public static void main(String[] args) {
        int [] [] matriu = new int [4] [4];
        int k = 1;
        int l = 1;
        int suma1 = 0;    // per sumar tots els valor em sembla que t'embulles ...
        int suma2 = 0;    // te sobra un acumulador, per exemple aquest
        //CON FOR BÁSICO
         /*for (int i = 0; i < matriu.length; i++){
            for (int j = 0; j < matriu[i].length; j++){
                matriu[i] [j] = k;
                k++;
                System.out.println(matriu[i][j]);
            }
        }
        //RECORREMOS CON FOR EACH
        for (int[] fila: matriu){
            
            for (int f : fila){
                System.out.println(f);
            }
        }*/

        //RELLENAMOS Y RECORREMOS CON FOR EACH
        for (int [] fila : matriu){
            for( int n = 0; n < fila.length; n++){
                fila[n] = l;
                
                System.out.println("-->" + fila[n]);                                
                //suma2 = fila[n] + suma1;
                //System.out.println(suma1 + " + " + fila[n] + " = " + suma2 );
                suma2 =  suma2 + l;
                l++;          

            }
        }  
        System.out.println("La suma total de todos los valores del array es " + suma2 + ".");      
    }
}