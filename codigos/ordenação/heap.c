#include <stdio.h>

void heapify(int array[], int n, int i) {
    int maior = i;
    int esq = 2*i+1;
    int dir = 2*i+2;

    if (esq < n && array[esq] > array[maior]) maior = esq;
    if (dir < n && array[dir] > array[maior]) maior = dir;

    if (maior != i) {
        int tmp = array[i];
        array[i] = array[maior];
        array[maior] = tmp;

        heapify(array, n, maior);
    }
}

void heapsort(int array[], int n) {
    for (int i = n/2-1; i >= 0; i--) {
        heapify(array, n, i);
    }

    for (int i = n-1; i > 0; i--) {
        int tmp = array[0];
        array[0] = array[i];
        array[i] = tmp;

        heapify(array, i, 0);
    }
}

void mostrarAncestrais(int array[], int n, int i) {
    if (i < 0 || i >= n) return;

    printf("%d ", array[i]);
    while (i > 0) {
        printf("%d ", array[i]);
        i = (i-1)/2;
    }
    printf("\n");
}

int main() {

    int array[] = {16, 14, 10, 13, 11, 8, 9, 7, 1, 5};

    for (int i = 0; i < 10; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    heapsort(array, 10);

    for (int i = 0; i < 10; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    return 0;
}

// sempre n log n
// in-place
// não é estável