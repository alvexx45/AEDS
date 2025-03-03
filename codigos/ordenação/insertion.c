void insertion(int array[], int length) {
    for (int i = 1; i < length; i++) {
        int tmp = array[i];
        int j = i - 1;
        
        while (j >= 0 && array[j] > tmp) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j + 1] = tmp;
    }
}