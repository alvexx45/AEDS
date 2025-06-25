import java.util.Scanner;

class Main {
    public static int compare(Pais a, Pais b) {
        if (a.ouro != b.ouro) return b.ouro - a.ouro;
        if (a.prata != b.prata) return b.prata - a.prata;
        if (a.bronze != b.bronze) return b.bronze - a.bronze;
        return a.nome.compareTo(b.nome);
    }

    public static void quicksort(Pais p[], int esq, int dir) {
        int i = esq, j = dir;
        Pais pivo = p[(esq+dir)/2];

        while (i <= j) {
            while (compare(p[i], pivo) < 0) i++;
            while (compare(p[j], pivo) > 0) j--;

            if (i <= j) {
                Pais tmp = p[i];
                p[i] = p[j];
                p[j] = tmp;
                i++; j--;
            }

            if (esq < j) quicksort(p, esq, j);
            if (i < dir) quicksort(p, i, dir);
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
        quicksort(p, 0, n-1);

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