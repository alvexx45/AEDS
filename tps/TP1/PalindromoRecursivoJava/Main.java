import java.util.Scanner;

public class Main {
    public static boolean palindromo(String s, int i) {
        if (i >= s.length() / 2) {
            return true;
        }

        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            return false;
        }

        return palindromo(s, i + 1);
    }

    public static boolean stop(String txt) {
        return (txt.length() == 3 && txt.charAt(0) == 'F' && txt.charAt(1) == 'I' && txt.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String frase = "";
        boolean flag = false;

        while (!flag) {
            frase = sc.nextLine();

            if (stop(frase)) {
                flag = true;
            } else {
                if (palindromo(frase, 0)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }

        sc.close();
    }
}
