#include <stdbool.h>

void bubble(int array[], int n) {
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (array[j] > array[j + 1]) {
                swap(j, j + 1);
            }
        }
    }
}

void bubbleopt(int array[], int n) {
    bool trocado;

    for (int i = 0; i < n-1; i++) {
        trocado = false;

        for (int j = 0; j < n-i-1; j++) {
            if (array[j] > array[j + 1]) {
                swap(j, j + 1);
                trocado = true; // marca que houve troca
            }
        }

        if (trocado == false) i = n-1; // array já ordenado
    }
}