// a) código em c-like

class Q4 {
    public static void selectionmod(int array[], int n) {
        int esq = 0;
        int dir = n;
    
        while (esq < dir - 1) {
            int menor = esq;
            int maior = esq;
    
            for (int i = esq; i < dir; i++) {
                if (array[i] < array[menor]) menor = i;
                if (array[i] > array[maior]) maior = i;
            }
            swap(array, menor, esq); // menor no inicio
    
            if (maior == esq) maior = menor;
            swap(array, maior, dir - 1); // maior no final
    
            esq++; // reduz subarr na esq
            dir--; // reduz subarr na dir

            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int array[] = { 29, 10, 14, 37, 13, 5, 26 };
        int n = array.length;

        selectionmod(array, n);
    }
}

// b) nova complexidade: permance O(n²)

// c) mostre o estado do array após cada iteração
// array inicial: [29, 10, 14, 37, 13, 5, 26]
// 1ª: [5, 10, 14, 26, 13, 29, 37]
// 2ª: [5, 10, 14, 26, 13, 29, 37]
// 3ª: [5, 10, 13, 14, 26, 29, 37]