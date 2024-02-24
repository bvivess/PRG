
package javaapplication5;

public class JavaApplication5 {
    
    public static void main(String[] args) {
        Shirts []   myShirts = {new Shirts(),new Shirts(),new Shirts()};
        //Shirts     myShirt2[];
        
        //myShirts = new Shirts[50];
        //  = new int[]{1,2,3};
       
        for ( Shirts s : myShirts ) {
            System.out.println(s.id + " " + s.descripcio);
        }
    }
    
}
