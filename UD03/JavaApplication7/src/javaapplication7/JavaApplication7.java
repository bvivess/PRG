package javaapplication7;


public class JavaApplication7 {

    public static void main (String [] args) {
		int[] a= {1,2,3}, b= {9,8,7}; 
		int	c;
		System.out.println(a[0] + " - " + b[0]);  // 1 - 9  RECORDA: EN CAS D'ARRAYS
		c = suma(a,b);                            //        ELS PAR?METRES ES PASSEN 
		System.out.println(a[0] + " - " + b[0]);  // 99 - 9 PER "VALOR DE REFER?NCIA" 
	}
    
	public static int suma(int[] y, int[] z) { 
            int total = 0;
            
            for (int i=0; i < y.length; i++) {
                total += y[i];
                for (int j=0; j < z.length; j++) {
                    y[i] += z[j];
                    total += z[j];
                }
            }
                        
            return total;
	}
}

