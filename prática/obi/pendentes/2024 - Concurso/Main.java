import java.util.Scanner;

class Main {
    public static int corte(int array[], int n, int k) {
        for (int i = 0; i < k; i++) {
            int maior = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] > array[maior]) {
                    maior = j;
                }
            }
            int tmp = array[i];
            array[i] = array[maior];
            array[maior] = tmp;
        }
    
        return array[k-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, k;
        while(sc.hasNextInt()) {
            n = sc.nextInt();
            k = sc.nextInt();
            
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            
            System.out.println(corte(array, n, k));
        }

        sc.close();
    }
}