#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const char *a, const char *b) {
    return strcmp(a, b);
}

void quicksort(char nomes[][31], int esq, int dir) {
    int i = esq, j = dir;
    char pivo[31];
    strcpy(pivo, nomes[(esq+dir)/2]);

    while (i <= j) {
        while (compare(nomes[i], pivo) < 0) i++;
        while (compare(nomes[j], pivo) > 0) j--;

        if (i <= j) {
            char tmp[31];
            strcpy(tmp, nomes[i]);
            strcpy(nomes[i], nomes[j]);
            strcpy(nomes[j], tmp);
            i++; j--;
        }
    }

    if (esq < j) quicksort(nomes, esq, j);
    if (i < dir) quicksort(nomes, i, dir);
}

int main() {
    int n;
    scanf("%d", &n);

    char comp;
    char nomes[n][31];
    int b = 0, m = 0;

    for (int i = 0; i < n; i++) {
        scanf(" %c %s", &comp, nomes[i]);
        if (comp == '+') b++;
        if (comp == '-') m++;
    }
    quicksort(nomes, 0, n-1);

    for (int i = 0; i < n; i++) {
        printf("%s\n", nomes[i]);
    }
    printf("Se comportaram: %d | Nao se comportaram: %d", b, m);

    return 0;
}