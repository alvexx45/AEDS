import java.util.Scanner;

class Main {
    public static void sort(Pais p[], int n) {
        for (int i = 0; i < n-1; i++) {
            int maior = i;
            for (int j = i+1; j < n; j++) {
                if(p[j].ouro > p[maior].ouro ||
                (p[j].ouro == p[maior].ouro && p[j].prata > p[maior].prata) ||
                (p[j].prata == p[maior].prata && p[j].bronze > p[maior].bronze) ||
                (p[j].bronze == p[maior].bronze && p[j].nome.compareTo(p[maior].nome) < 0)){
                    maior = j;
                }
            }
            
            Pais tmp = p[i];
            p[i] = p[maior];
            p[maior] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Pais p[] = new Pais[n];

        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            int ouro = sc.nextInt();
            int prata = sc.nextInt();
            int bronze = sc.nextInt();

            p[i] = new Pais(nome, ouro, prata, bronze);
        }
        sort(p, n);

        for (int i = 0; i < n; i++) {
            System.out.printf("%s %d %d %d\n", p[i].nome, p[i].ouro, p[i].prata, p[i].bronze);
        }

        sc.close();
    }
}

class Pais {
    String nome;
    int ouro, prata, bronze;

    Pais(String nome, int ouro, int prata, int bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}