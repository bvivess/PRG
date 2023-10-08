Algoritmo ACT1_5
 	Mostrar "Elija la conversión que desea realizar:"
 	Mostrar "1. Celsius a Fahrenheit"
 	Mostrar "2. Fahrenheit a Celsius"
	Leer eleccion
 	Mostrar "Introduzca la temperatura:"
 	Leer temperatura
 	Si (eleccion es igual a 1) entonces
 		resultado = (temperatura * 9/5) + 32
 	Sino 
		resultado = (temperatura - 32) * 5/9
	Fin Si
	Mostrar "El resultado es: " resultado
Fin Algoritmo