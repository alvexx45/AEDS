import java.util.Scanner;

class Main {
    public static int compare(Piloto a, Piloto b) {
        if (a.peso != b.peso) return a.peso - b.peso;
        if (a.rank != b.rank) return a.rank - b.rank;
        return a.nome.compareTo(b.nome);
    }

    public static void quicksort(Piloto[] p, int esq, int dir) {
        int i = esq, j = dir;
        Piloto pivo = p[(esq+dir)/2];

        while (i <= j) {
            while (compare(p[i], pivo) < 0) i++;
            while (compare(p[j], pivo) > 0) j--;

            if (i <= j) {
                Piloto tmp = p[i];
                p[i] = p[j];
                p[j] = tmp;
                i++; j--;
            }
        }

        if (esq < j) quicksort(p, esq, j);
        if (i < dir) quicksort(p, i, dir);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Piloto[] p = new Piloto[n];
        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            int peso = sc.nextInt();
            int rank = sc.nextInt();

            p[i] = new Piloto(nome, peso, rank);
        }
        quicksort(p, 0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.printf("%s %d %d\n", p[i].nome, p[i].peso, p[i].rank);
        }

        sc.close();
    }
}

class Piloto {
    String nome;
    int peso, rank;

    Piloto(String nome, int peso, int rank) {
        this.nome = nome;
        this.peso = peso;
        this.rank = rank;
    }
}