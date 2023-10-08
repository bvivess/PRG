Algoritmo ACT1_9
	contarLA = 0
	Mostrar "Introduzca caracteres, -X- para salir"
	Leer carAct
	Mientras (carAct es distinto a "X") hacer
		carAnt = carAct
		Leer carAct
		Si (carAnt es igual a 'L') y (carAct = 'A') entonces
			contarLA = contarLA + 1
        Fin Si
 	Fin Mientras
 	Mostrar "La suma -LA- es: ", contarLA
Fin Algoritmo