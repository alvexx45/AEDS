public static int[] vetorOrdenado(int[] vetA, int[] vetB) {
    int m = vetA.length;
    int n = vetB.length;
    int[] vetC = new int[m+n];

    int i = m-1;
    int j = n-1;
    int k = 0;
    
    // combinar os arrays
    while (i >= 0 && j >= 0) {
        if (vetA[i] <= vetB[j]) {
            vetC[k++] = vetA[i--];
        } else {
            vetC[k++] = vetB[j--];
        }
    }

    // adicionar elementos restantes
    while (i >= 0) vetC[k++] = vetA[i--];
    while (j >= 0) vetC[k++] = vetA[j--];

    return vetC;
}