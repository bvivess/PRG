import java.util.Scanner;

public class Prova {
    public static void main(String[ ] args) {
        if (args.length == 0) {
			System.out.println("no args");
		} else {
			for (String a: args) {
				System.out.println(a);
			}
		}
    }
}
