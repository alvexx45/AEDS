void selection(int array[], int n) {
    int mov = 0;

    for (int i = 0; i < n - 1; i++) {
        int menor = i;
        for (int j = i + 1; j < n; j++) {
            if (array[j] < array[menor]) {
                menor = j;
            }
        }
        int tmp = array[i];
        array[i] = array[menor];
        array[menor] = tmp;
        mov += 3;
    }    
}

void selectionmod(int array[], int n) {
    int esq = 0;
    int dir = n;

    while (esq < dir) {
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
    }
}