import java.util.Scanner;

class Main {
    public static int contagem(String frase) {
        frase = frase.trim();
        String[] palavras = frase.split("\\s+");

        return palavras.length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String frase = sc.nextLine();

        while(!frase.equals("FIM")) {
            System.out.println(contagem(frase));
            frase = sc.nextLine();
        }

        sc.close();
    }
}