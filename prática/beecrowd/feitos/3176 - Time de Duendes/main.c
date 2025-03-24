#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[21];
    int idade;
} Duende;

int compare(const void *a, const void *b) {
    Duende *d1 = (Duende *)a;
    Duende *d2 = (Duende *)b;

    return d2->idade - d1->idade;
    return strcmp(d1->nome, d2->nome);

}

int main() {
    int n;
    scanf("%d", &n);

    Duende d[n];
    for (int i = 0; i < n; i++) {
        scanf("%s %d", d[i].nome, &d[i].idade);
    }
    qsort(d, n, sizeof(Duende), compare);

    for (int i = 0; i < n / 3 ; i++) {
        if (i > 0) printf("\n");

        printf("Time %d\n", i + 1);
        printf("%s %d\n", d[i].nome, d[i].idade);
        printf("%s %d\n", d[i + 2].nome, d[i + 2].idade);
        printf("%s %d\n", d[n - 2 + i].nome, d[n - 2 + i].idade);
    }

    return 0;
}