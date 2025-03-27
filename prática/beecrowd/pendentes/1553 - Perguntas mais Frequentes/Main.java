import java.util.Scanner;

class Main {
    public static int frequentes(int[] perg, int n, int k) {
        int res = 0;
        boolean[] contado = new boolean[101];

        for (int i = 0; i < n; i++) {
            if (!contado[perg[i]]) {
                int cont = 0;
                for (int j = 0; j < n; j++) {
                    if (perg[i] == perg[j]) {
                        cont++;
                    }
                }
                if (cont >= k) {
                    res++;
                    contado[perg[i]] = true;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        while (n != 0 && k != 0) {
            int[] perg = new int[n];
            
            for (int i = 0; i < n; i++) {
                perg[i] = sc.nextInt();
            }
            System.out.println(frequentes(perg, n, k));

            n = sc.nextInt();
            k = sc.nextInt();    
        }

        sc.close();
    }
}