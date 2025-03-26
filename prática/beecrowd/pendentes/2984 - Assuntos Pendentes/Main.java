import java.util.Scanner;

class Main {
    public static int assuntos(String str) {
        int cont = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cont++;
            } else if (str.charAt(i) == ')' && cont > 0) {
                cont--;
            }
        }

        return cont;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String str = sc.nextLine();

            int res = assuntos(str);
            if (res == 0) {
                System.out.println("Partiu RU!");
            } else {
                System.out.printf("Ainda temos %d assunto(s) pendente(s)!\n", res);
            }
        }

        sc.close();
    }
}