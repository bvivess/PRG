Algoritmo ACT1_12
	Mostrar "Introduzca el número mínimo del rango"
	Leer numMin
	Mostrar "Introduzca el número máximo del rango"
	Leer numMax
	Mostrar "Los Números primos son:"
	Para numero desde numMin hasta maximo hacer // → desde MAX(numMin,2) a numMax
		// Un número no es primo lo cuando es divisible por cualquier anterior
		// excepto 1 y sí mismo
		esPrimo = Verdadero
		Para i desde 2 hasta numero-1 hacer
			Si numero es divisible por i entonces
				esPrimo = Falso
			Fin Si	
		Fin para
		Si esPrimo entonces
			Mostrar numero
		Fin Si	  
	Fin para
Fin Algoritmo