Algoritmo ACT1_9B
	contarLA = 0
	carAnt = ""
	Mostrar "Introduzca caracteres, -X- para salir'
	Repetir
		Leer carAct
		carAnt = carAct
		Si (carAnt == 'L') y (carAct == 'A') entonces
			contarLA = contarLA + 1
		Fin Si
	Hasta que (carAct es igual a "X")	
	Mostrar "La suma -LA- es: " contarLA
Fin Algoritmo