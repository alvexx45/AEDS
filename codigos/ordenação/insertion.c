int binsearch(int array[], int right, int x) {
    int left = 0;

    while (left <= right) {
        int middle = ((left + right) / 2);
        if (array[middle] == x) {
            return middle + 1;
        } else if (array[middle] > x) {
            right = middle - 1;
        } else {
            left = middle + 1;
        }
    }

    return left;
}

void insertionOpt(int array[], int length) {
    for (int i = 1; i < length; i++) {
        int tmp = array[i];
        int j = i - 1;
        int localizar = binsearch(array, i, array[i]);
        
        while (j <= localizar) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = tmp;
    }
}

void insertion(int array[], int length) {
    for (int i = 1; i < length; i++) {
        int tmp = array[i];
        int j = i - 1;
        
        while (j >= 0 && array[j] > tmp) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = tmp;
    }
}