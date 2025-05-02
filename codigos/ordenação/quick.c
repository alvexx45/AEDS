#include <stdio.h>

void quicksort(int array[], int esq, int dir) {
    int i = esq, j = dir, pivo = array[(esq+dir)/2];

    while (i <= j) {
        while (array[i] < pivo) i++;
        while (array[j] > pivo) j--;

        if (i <= j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++; j--;
        }

        if (esq < j) quicksort(array, esq, j);
        if (i < dir) quicksort(array, i, dir);
    }
}

int main() {
    int array[16] = {0, 1, 12, 9, 88, 13, 40, 2, 15, 75, 5, 3, 15, 16, 9, 10};

    for (int i = 0; i < 16; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    quicksort(array, 0, 16-1);
    
    for (int i = 0; i < 16; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    return 0;
}