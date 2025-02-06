#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[30];
    int peso, idade;
    float alt;
} Renas;

int compare(const void *a, const void *b) {
    Renas *r1 = (Renas *)a;
    Renas *r2 = (Renas *)b;
    
    if (r2->peso != r1->peso)
        return r2->peso - r1->peso;
    
    if (r1->idade != r2->idade) 
        return r1->idade - r2->idade;

    if (r1->alt != r2->alt)
        return (r1->alt - r2->alt) ? 1 : -1;

    return strcmp(r1->nome, r2->nome);
}

int main() {
    int t;
    scanf("%d", &t);

    for (int i = 0; i < t; i++) {
        int n, m;
        scanf("%d %d", &n, &m);

        Renas r[n];

        for (int j = 0; j < n; j++) {
            scanf("%s %d %d %f", r[j].nome, &r[j].peso, &r[j].idade, &r[j].alt);
        }
        qsort(r, n, sizeof(Renas), compare);

        printf("CENARIO {%d}\n", i + 1);
        for (int k = 0; k < m; k++) {
            printf("%d - %s\n", k + 1, r[k].nome);
        }
    }

    return 0;
}   