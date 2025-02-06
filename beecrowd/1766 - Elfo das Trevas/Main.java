import java.util.*;

class Main {
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

            Arrays.sort(r, (r1, r2) -> {
                if (r1.peso != r2.peso)
                    return r2.peso - r1.peso;
    
                if (r1.idade != r2.idade)
                    return r1.idade - r2.idade;

                if (Double.compare(r1.alt, r2.alt) != 0) {
                    return Double.compare(r2.alt, r1.alt);
                }

                return r1.nome.compareTo(r2.nome);
            });

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