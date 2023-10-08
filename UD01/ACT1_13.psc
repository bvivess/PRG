Algoritmo ACT1_13
	Mostrar "Introduzca un número"
	Leer numero
	fibN2 = 0 
	fibN1 = 1  
	Mostrar "Los números de la secuencia de Fibonacci son:"
	Mostrar fibN2
	Mostrar fibN1
	Para i desde 3 hasta numero hacer
		fibN = fibN2 + fibN1
		Mostrar (fibN)
		fibN2 = fibN1
		fibN1 = fibN
	Fin para
Fin Algoritmo