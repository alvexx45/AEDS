#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[21];
    int ouro, prata, bronze;
} Pais;

int compare(const Pais *a, const Pais *b) {
    if (a->ouro != b->ouro) return b->ouro - a->ouro;
    if (a->prata != b->prata) return b->prata - a->prata;
    if (a->bronze != b->bronze) return b->bronze - a->bronze;
    return strcmp(a->nome, b->nome);
}

void quicksort(Pais p[], int esq, int dir) {
    int i = esq, j = dir;
    Pais pivo = p[(esq+dir)/2];

    while (i <= j) {
        while (compare(&p[i], &pivo) < 0) i++;
        while (compare(&p[j], &pivo) > 0) j--;

        if (i <= j) {
            Pais tmp = p[i];
            p[i] = p[j];
            p[j] = tmp;
            i++; j--;
        }
    }

    if (esq < j) quicksort(p, esq, j);
    if (i < dir) quicksort(p, i, dir);
}

int main() {
    int n;
    scanf("%d", &n);

    Pais p[n];

    for (int i = 0; i < n; i++) {
        scanf("%s %d %d %d", p[i].nome, &p[i].ouro, &p[i].prata, &p[i].bronze);
    }
    quicksort(p, 0, n-1);

    for (int i = 0; i < n; i++) {
        printf("%s %d %d %d\n", p[i].nome, p[i].ouro, p[i].prata, p[i].bronze);
    }

    return 0;
}