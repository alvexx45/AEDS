import java.util.Scanner;

class Main {
    public static void quicksort(Confeccao[] confeccao, int left, int right) {
        if (left < right) {
            int pivo = partition(confeccao, left, right);
            quicksort(confeccao, left, pivo - 1);
            quicksort(confeccao, pivo + 1, right);
        }
    }

    public static int partition(Confeccao[] confeccao, int left, int right) {
        Confeccao pivo = confeccao[right];

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (confeccao[j].compareTo(pivo) <= 0) {
                i++;
                Confeccao temp = confeccao[i];
                confeccao[i] = confeccao[j];
                confeccao[j] = temp;
            }

        }
        Confeccao temp = confeccao[i + 1];
        confeccao[i + 1] = confeccao[right];
        confeccao[right] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n != 0) {
            Confeccao c[] = new Confeccao[n];

            for (int i = 0; i < n; i++) {
                sc.nextLine();
                String nome = sc.nextLine();
                String cor = sc.next();
                char tam = sc.next().charAt(0);

                c[i] = new Confeccao(nome, cor, tam);
            }
            quicksort(c, 0, c.length - 1);

            for (Confeccao conf : c) {
                System.out.println(conf.cor + " " + conf.tam + " " + conf.nome);
            }
            System.out.println();

            n = sc.nextInt();
        }

        sc.close();
    }
}

class Confeccao implements Comparable<Confeccao>{
    String nome, cor;
    char tam;

    public Confeccao(String nome, String cor, char tam) {
        this.nome = nome;
        this.cor = cor;
        this.tam = tam;
    }

    @Override
    public int compareTo(Confeccao outra) {
        int cmp = this.cor.compareTo(outra.cor);
        if (cmp != 0) {
            return cmp;
        }

        if (this.tam != outra.tam) {
            if (this.tam == 'P') return -1;
            if (outra.tam == 'P') return 1;
            if (this.tam == 'M') return -1;
            if (outra.tam == 'M') return 1;
        }

        return this.nome.compareTo(outra.nome);
    }
}