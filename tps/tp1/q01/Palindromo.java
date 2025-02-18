import java.util.Scanner;

public class Palindromo {

    // Método que checa se a string é um palíndromo
    public static boolean validPalindromo(String txt) {
        for (int i = 0, j = txt.length() - 1; i < j; i++, j--) {
            if (txt.charAt(i) != txt.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String texto = "";
        boolean flag = false;

        for (int i = 0; flag != true; i++) {
            texto = scanner.nextLine();

            if (texto.length() == 3 && texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M') {
                flag = true;
            } else {
                if (validPalindromo(texto)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }

        scanner.close();
    }
}

