import java.util.Scanner;

class Main {
    public static void sort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len-1; i++) {
            int menor = i;
            for (int j = i+1; j < len; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }

            int tmp = array[i];
            array[i] = array[menor];
            array[menor] = tmp;
        }
    }

    public static void contar(int[] array) {
        int len = array.length;
        int aux[] = new int[len];
        boolean[] salvo = new boolean[101];
        
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (i >= 1 && !salvo[array[i]]) {
                if (array[i] == array[i-1]) {
                    aux[j] = array[i];
                    salvo[array[i]] = true;
                    j++;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (aux[i] != 0) {
                System.out.print(aux[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        while (n != 0 && m != 0) {
            int[] array = new int[n*m];
            int len = array.length;

            for (int i = 0; i < len; i++) {
                array[i] = sc.nextInt();
            }
            sort(array);
            contar(array);

            n = sc.nextInt();
            m = sc.nextInt();
        }

        sc.close();
    }
}

