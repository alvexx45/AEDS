import java.util.Scanner;

class Main {
    public static int compare(String a, String b) {
        return a.compareTo(b);
    }

    public static void quicksort(String[] nomes, int esq, int dir) {
        int i = esq, j = dir;
        String pivo = nomes[(esq+dir)/2];

        while (i <= j) {
            while(compare(nomes[i], pivo) < 0) i++;
            while(compare(nomes[j], pivo) > 0) j--;

            if (i <= j) {
                String tmp = nomes[i];
                nomes[i] = nomes[j];
                nomes[j] = tmp;
                i++; j--;
            }
        } 

        if (esq < j) quicksort(nomes, esq, j);
        if (i < dir) quicksort(nomes, i, dir);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String nomes[] = new String[n];
        int b = 0, m = 0;

        for (int i = 0; i < n; i++) {
            String linha = sc.nextLine().trim();
            char comp = linha.charAt(0);
            nomes[i] = linha.substring(2).trim();

            if (comp == '+') b++;
            if (comp == '-') m++;
        }
        quicksort(nomes, 0, n-1);

        for (String nome : nomes) {
            System.out.println(nome);
        }
        System.out.printf("Se comportaram: %d | Nao se comportaram: %d", b, m);

        sc.close();
    }
}