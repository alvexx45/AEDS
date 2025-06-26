import java.util.Scanner;

class Main {
    public static void quicksort(Duende[] d, int esq, int dir) {
        int i = esq, j = dir;
        Duende pivo = d[(esq + dir) / 2];

        while (i <= j) {
            while (d[i].idade > pivo.idade ||
                    (d[i].idade == pivo.idade && d[i].nome.compareTo(pivo.nome) < 0)) {
                i++;
            }
            while (d[j].idade < pivo.idade ||
                    (d[j].idade == pivo.idade && d[j].nome.compareTo(pivo.nome) > 0)) {
                j--;
            }

            if (i <= j) {
                Duende tmp = d[i];
                d[i] = d[j];
                d[j] = tmp;
                i++;
                j--;
            }
        }

        if (esq < j)
            quicksort(d, esq, j);
        if (i < dir)
            quicksort(d, i, dir);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Duende[] d = new Duende[n];

        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            int idade = sc.nextInt();
            d[i] = new Duende(nome, idade);
        }
        quicksort(d, 0, n - 1);

        for (int i = 0; i < n / 3; i++) {
            if (i > 0)
                System.out.println();

            System.out.printf("Time %d\n", i + 1);
            System.out.printf("%s %d\n", d[i].nome, d[i].idade);
            System.out.printf("%s %d\n", d[i + 2].nome, d[i + 2].idade);
            System.out.printf("%s %d\n", d[n - 2 + i].nome, d[n - 2 + i].idade);
        }

        sc.close();
    }
}

class Duende {
    String nome;
    int idade;

    public Duende(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}