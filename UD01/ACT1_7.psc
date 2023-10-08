Algoritmo ACT1_7
	Mostrar "Operación:"
	Mostrar "Suma (+)"
	Mostrar "Resta (-)"
	Mostrar "Multiplicación (*)"
	Mostrar "División (/)"
	Leer operacion
	Mostrar "Introduzca el primer número:"
	Leer numero1
	Mostrar "Introduzca el segundo número:"
	Leer numero2
 	Si (operacion es igual a "+") entonces
 		resultado = numero1 + numero2
 	Sino 
		Si (operacion es igual a "-") entonces
			resultado = numero1 - numero2
		Sino 
			Si (operacion es igual a "*") entonces
				resultado = numero1 * numero2
			Sino 
				Si (operacion es igual a "/") entonces
					Si (numero2 es igual a 0)
						Mostrar "Error: No se puede dividir por cero."
					Sino
						resultado = numero1 / numero2
					Fin Si
				Fin Si
			Fin Si
		Fin Si
 	Fin Si
 	Mostrar "El resultado de la " operacion " es: " resultado
Fin Algoritmo