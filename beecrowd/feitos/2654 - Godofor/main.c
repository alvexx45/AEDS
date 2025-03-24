#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[20];
    int power, kills, mortes;
} Deuses;

// int compare(const void *a, const void *b) {
    // Deuses *d1 = (Deuses *)a;
    // Deuses *d2 = (Deuses *)b;
// 
    // return d2->power - d1->power;
    // return d2->kills - d1->kills;
    // return d2->mortes - d1->mortes;
    // return strcmp(d1->nome, d2->nome);
// }

void sort (Deuses d[], int n) {
    for (int i = 0; i < n-1; i++) {
        int menor = i;
    }
}

int main() {
    int n;
    scanf("%d", &n);

    Deuses d[n];

    for (int i = 0; i < n; i++) {
        scanf("%s %d %d %d", d[i].nome, &d[i].power, &d[i].kills, &d[i].mortes);
    }
    sort(d, n);

    // qsort(d, n, sizeof(Deuses), compare);
    printf("%s", d[0].nome);

    return 0;
}