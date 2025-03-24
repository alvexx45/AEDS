import java.util.Scanner;

public class Main {
    public static int contar(String vogais, String frase) {
        int cont = 0;

        for (int i = 0; i < vogais.length(); i++) {
            for (int j = 0; j < frase.length(); j++) {
                if (vogais.charAt(i) == frase.charAt(j)) {
                    cont++;
                }
            }
        }

        return cont;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String vogais = sc.nextLine();
            String frase = sc.nextLine();
            System.out.println(contar(vogais, frase));
        }

        sc.close();
    }
}