void quicksort(int[] array, int left, int right) {
    if (left < right) {
        int pivo = partition(array, left, right);
        quicksort(array, left, pivo - 1);
        quicksort(array, pivo + 1, right);
    }
}

int partition(int[] array, int left, int right) {
    int pivo = array[right];

    int i = left - 1;
    for (int j = left; j < right; j++) {
        if (array[j] <= pivo) {
            i++;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }
    
    int temp = array[i + 1];
    array[i + 1] = array[right];
    array[right] = temp;

    return i + 1;
}