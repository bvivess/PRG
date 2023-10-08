Algoritmo ACT1_4
 	Mostrar "Introduzca su calificación" 
 	Leer calificacion
 	Si (calificacion es mayor o igual a 9) entonces
    	Mostrar "Sobresaliente"
 	Sino 
		Si (calificacion es mayor o igual a 7) entonces
    		Mostrar "Notable"
 		Sino 
			Si (calificacion es mayor o igual a 6) entonces
				Mostrar "Bien"
			Sino 
				Si (calificacion es mayor o igual a 5) entonces
					Mostrar "Aprobado"
				Sino
					Si (calificacion es mayor o igual a 3) entonces
						Mostrar "Insuficiente"
					Sino
						Mostrar "Muy deficiente"
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Fin Si
Fin Algoritmo