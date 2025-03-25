import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int n = sc.nextInt();
        Cobaias[] c = new Cobaias[n];

        int coelhos = 0, ratos = 0, sapos = 0;
        for (int i = 0; i < n; i++) {
            int qtd = sc.nextInt();
            char tipo = sc.next().charAt(0);

            c[i] = new Cobaias(qtd, tipo);

            if (c[i].tipo == 'C') {
                coelhos += c[i].qtd;
            } else if (c[i].tipo == 'R') {
                ratos += c[i].qtd;
            } else {
                sapos += c[i].qtd;
            }
        }
        int soma = coelhos + ratos + sapos;

        double pCoelhos = (coelhos * 100.0) / soma;
        double pRatos = (ratos * 100.0) / soma;
        double pSapos = (sapos * 100.0) / soma;

        System.out.printf("Total: %d cobaias\n", soma);
        System.out.printf("Total de coelhos: %d\n", coelhos);
        System.out.printf("Total de ratos: %d\n", ratos);
        System.out.printf("Total de sapos: %d\n", sapos);
        System.out.printf("Percentual de coelhos: %.2f %%\n", pCoelhos);
        System.out.printf("Percentual de ratos: %.2f %%\n", pRatos);
        System.out.printf("Percentual de sapos: %.2f %%\n", pSapos);

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