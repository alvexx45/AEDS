#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[21];
    int peso, rank;
} Piloto;

int compare(const Piloto *a, const Piloto *b) {
    if (a->peso != b->peso) return a->peso - b->peso;
    if (a->rank != b->rank) return a->rank - b->rank;
    return strcmp(a->nome, b->nome);
}

void quicksort(Piloto p[], int esq, int dir) {
    int i = esq, j = dir;
    Piloto pivo = p[(esq+dir)/2];

    while (i <= j) {
        while (compare(&p[i], &pivo) < 0) i++;
        while (compare(&p[j], &pivo) > 0) j--;
        
        if (i <= j) {
            Piloto tmp = p[i];
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

    Piloto p[n];
    for (int i = 0; i < n; i++) {
        scanf("%s %d %d", p[i].nome, &p[i].peso, &p[i].rank);
    }
    quicksort(p, 0, n-1);

    for (int i = 0; i < n; i++) {
        printf("%s %d %d\n", p[i].nome, p[i].peso, p[i].rank);
    }

    return 0;
}   