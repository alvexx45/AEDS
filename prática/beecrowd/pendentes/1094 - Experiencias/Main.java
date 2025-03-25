import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cobaias[] c = new Cobaias[n];

        int coelhos = 0, ratos = 0, sapos = 0;
        for (int i = 0; i < n; i++) {
            int qtd = sc.nextInt();
            char tipo = sc.next().charAt(0);

            c[i] = new Cobaias(qtd, tipo);

            if (c[i].tipo == 'C') {
                
            }
        }

        int soma = coelhos + ratos + sapos;

        sc.close();
    }
}

class Cobaias {
    int qtd;
    char tipo;

    Cobaias(int qtd, char tipo) {
        this.qtd = qtd;
        this.tipo = tipo;
    }
}