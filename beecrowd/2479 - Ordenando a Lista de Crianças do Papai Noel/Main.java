import java.util.Scanner;

class Main {
    public static void selection(int n, String nomes[]) {
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                if (!nomes[j].equals(nomes[menor])) {
                    menor = j;
                }
            }

            if (menor != i) {
                String tmp = nomes[i];
                nomes[i] = nomes[menor];
                nomes[menor] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char comp;
        String nomes[] = new String[n];
        int b = 0, m = 0;

        for (int i = 0; i < n; i++) {
            comp = sc.next().charAt(0);
            nomes[i] = sc.nextLine();
            if (comp == '+') b++;
            if (comp == '-') m++;
        }
        selection(n, nomes);

        for (int i = 0; i < n; i++) {
            System.out.println(nomes[i]);
        }
        System.out.printf("Se comportaram: %d | Nao se comportaram: %d", b, m);

        sc.close();
    }
}