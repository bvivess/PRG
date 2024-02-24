package palindrome;

public class Palindrome {

    public static boolean solution(char array[] ) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        char entrada[] = { 'a','b','c','b','z' };
        boolean sortida = solution( entrada );
        
        System.out.println(sortida);
    }
    
}
