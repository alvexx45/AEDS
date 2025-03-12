#include <stdbool.h>

bool binsearch(int array[], int n, int x) {
    bool resp = false;
    int esq = 0, dir = n - 1, meio;

    while (esq <= dir) {
        meio = (esq + dir) / 2;

        if (array[meio] == x) {
            resp = true;
            esq = n;
        } else if (array[meio] > x) {
            esq = meio + 1;
        } else {
            dir = meio - 1;
        }
    }

    return resp;
}