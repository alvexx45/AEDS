#include <stdbool.h>

bool binsearch(int array[], int n, int x) {
    bool resp = false;
    int esq = 0, dir = n-1;

    while (esq <= dir) {
        int meio = (esq + dir) / 2;

        if (array[meio] == x) {
            resp = true;
            esq = n;
        } else if (array[meio] < x) {
            esq = meio + 1;
        } else {
            dir = meio - 1;
        }
    }

    return resp;
}

int binsearchrec(int array[], int x, int esq, int dir) {
    if (esq > dir) return -1;

    int meio = (esq + dir) / 2;
    
    if (array[meio] == x) {
        return meio;
    } else if (array[meio] < x) {
        binsearchrec(array, x, meio + 1, dir);
    } else {
        binsearchrec(array, x, esq, meio - 1);
    }
}
