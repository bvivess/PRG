public class prova {
    public static void main ( String [] args ) {
        int a = 1, b = 2, c = 4, d = 1;
        float r, s = (float) 3.0;
		double z;

        r = (a + b / c + d * a);  // 1+2/4+1*1 → 1+2/4+1 → 1+0+1 → 2 
        System.out.println ( r ); // 2.0
        s = (r - s);              // 2.0-3.0 -> -1.0
        System.out.println ( s ); // -1.0
        r = (long) s ;            // 
        System.out.println ( r );
        r = ++r ;
        System.out.println ( r );
		z = 1/2;
		System.out.println(z);
    }
}


