import java.util.Scanner;

class Main {
    public static int selection(int n, int dna[]) {
        int trocas = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                if (dna[j] < dna[menor]) {
                    menor = j;
                }
            }

            if (menor != i) {
                int tmp = dna[i];
                dna[i] = dna[menor];
                dna[menor] = tmp;
                trocas++;
            }
        }

        return trocas;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int dna[] = new int[n];

            for (int j = 0; j < n; j++) {
                dna[j] = sc.nextInt();
            }

            int trocas = selection(n, dna);
            System.out.println(trocas);
        }

        sc.close();
    }
}