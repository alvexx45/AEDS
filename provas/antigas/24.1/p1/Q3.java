class Q3 {
    public static void bubblesort(int[] array, int n) {
        for (int i = 0; i < n-1; i++) {
            boolean trocado = false;

            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    trocado = true;
                }
            }

            if (trocado == false) {
                System.out.println("Já ordenado");
                i = n-1;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9, 23, 14, 5, 7, 1};
        // int[] array = {1, 5, 7, 9, 14, 23};
        bubblesort(array, array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

// a) A adição da flag "trocado" permite que o código seja interrompido se não houver necessidade de trocas

// b) A complexidade será O(n) no melhor caso que é quando array já ordenado e O(n²) no pior