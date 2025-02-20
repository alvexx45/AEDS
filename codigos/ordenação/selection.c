int selection(int array[], int n) {
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