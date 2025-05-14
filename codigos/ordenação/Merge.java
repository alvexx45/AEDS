class Merge {
    public static void mergesort(int[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio+1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    private static void intercalar(int[] array, int esq, int meio, int dir) {
        int n1 = meio-esq+1;
        int n2 = dir-meio;
        int i, j, k;

        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        for (i = 0; i < n1; i++) {
            a1[i] = array[esq+i];
        }

        for (j = 0; j < n2; j++) {
            a2[j] = array[meio+j+1];
        }

        i = 0; j = 0; k = esq;

        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                array[k++] = a1[i++];
            } else {
                array[k++] = a2[j++];
            }
        }

        while (i < n1) array[k++] = a1[i++];
        while (j < n2) array[k++] = a2[j++];
    }
}

// n logn em todos os casos
// estável
