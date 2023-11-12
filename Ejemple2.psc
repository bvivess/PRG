Proceso calculadora
	operacio = LlegirOperacio
	op1 = LlegirOperador("Introdueixi el primer número: ")
	op2 = LlegirOperador("Introdueixi el segundo número: ")
	resultat = Calcular(operacio, op1, op2)
FinProceso

Funcion operacio<-LlegirOperacio 
	Mostrar "Quina operació vol realitzar?"
	Mostrar "+: Sumar"
	Mostrar "-: Restar"
	Mostrar "*: Multiplicar"
	Mostrar "/: Dividir"
	Leer operacio
FinFuncion

Funcion operador<-LlegirOperador(text)
	Mostrar text
	Leer operador
FinFuncion

Funcion resultat<-Calcular(operacio, op1, op2)
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
FinFuncion
	