import java.util.Arrays;
public class Prova {

	public static void main ( String [] args ) {
		int a =1 , b =2 , c =3 , d =1;
		float r , s =( float ) 3.0;
		
		r = a + b / c + d / a ;     // aqui ( a + b / c + d / a ) = 2
		                            // pero r es 'float', por tanto un 2 
									// guardado en formato 'float' da el siguiente 
									// resultado: r = 2.0 
		System.out.println ( r );   // aquí lo puedes comprobar
		
		s =r - s ;                  // s = 2.0 - 3.0 = -1.0
		System.out.println ( s );   // aquí lo puedes comprobar
		
		r =( long ) s ;             // (long) -1.0 = -1
		                            // puesto que 'long' en un numero entero sin decimales 
		                            // pero aquí pasa lo mismo que antes, r es 'float'
									// y un 1 guardado en formato 'float' es 1.0
		                            // r = -1.0 puesto que r es 'float'
		r =++ r ;                   // r = 0.0 puesto que r es 'float'

		System.out.println ( r );   // r = 0.0
		                            // aquí lo puedes comprobar
	}
}
