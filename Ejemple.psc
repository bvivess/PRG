Proceso calculadora
	Mostrar "Quina operació vol realitzar?"
	Mostrar "+: Sumar"
	Mostrar "-: Restar"
	Mostrar "*: Multiplicar"
	Mostrar "/: Dividir"
	Leer operacio
	Mostrar "Introdueixi el primer número: "
	Leer op1
	Mostrar "Introdueixi el segundo número: "
	Leer op2
	Si operacio = "+" Entonces
		resultat = op1 + op2
	Sino
		Si operacio = "-" Entonces
			resultat = op1 - op2
		Sino
			Si operacio = "*" Entonces
				resultat = op1 * op2
			Sino
				Si operacio = "/" Entonces
					resultat = op1 / op2
				FinSi
			FinSi
		FinSi
	FinSi
	Mostrar "La operació és " resultat
FinProceso

	