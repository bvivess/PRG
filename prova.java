public class prova {

	public static void main (String[] args) {
		String str1 = "Hola";
		String str2 = "Hola";

		if (str1.equals(str2)) {
			System.out.println("Las cadenas son iguales");
		} else {
			System.out.println("Las cadenas son diferentes");
		}
		if (str1==str2) {
			System.out.println("Las cadenas son iguales");
		} else {
			System.out.println("Las cadenas son diferentes");
		}
	}
}