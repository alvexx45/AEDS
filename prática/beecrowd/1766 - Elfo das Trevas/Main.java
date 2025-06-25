import java.util.*;

class Main {
    public static void sort(Renas r[], int n) {
        for (int i = 0; i < n-1; i++) {
            int maior = i;
            for (int j = i+1; j < n; j++) {
                if (r[maior].peso < r[j].peso) {
                    maior = j;
                } else if (r[maior].peso == r[j].peso) {
                    if (r[maior].idade > r[j].idade) {
                        maior = j;
                    } else if (r[maior].idade == r[j].idade) {
                        if (r[maior].alt < r[j].alt) {
                            maior = j;
                        } else if (r[maior].alt == r[j].alt) {
                            if (r[maior].nome.compareTo(r[j].nome) > 0) {
                                maior = j;
                            }
                        }
                    }
                }
            }

            if (maior != i) {
                Renas tmp = r[i];
                r[i] = r[maior];
                r[maior] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Renas[] r = new Renas[n];

            for (int j = 0; j < n; j++) {
                String nome = sc.next();
                int peso = sc.nextInt();
                int idade = sc.nextInt();
                double alt = sc.nextDouble();

                r[j] = new Renas(nome, peso, idade, alt);
            }
            sort(r, n);

            System.out.printf("CENARIO {%d}\n", i + 1);
            for (int k = 0; k < m; k++) {
                System.out.printf("%d - %s\n", k + 1, r[k].nome);
            }

        }

        sc.close();
    }
}

class Renas {
    String nome;
    int peso, idade;
    double alt;

    public Renas(String nome, int peso, int idade, double alt) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.alt = alt;
    }
}