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
    
    if (r1->peso != r2->peso)
        return r2->peso - r1->peso;
    
    if (r1->idade != r2->idade) 
        return r1->idade - r2->idade;

    if (r1->alt != r2->alt)
        return r2->alt - r1->alt;

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
            scanf("%s %d %d %f", r[i].nome, &r[i].peso, &r[i].idade, &r[i].alt);
        }
        qsort(r, n, sizeof(Renas), compare);

        for (int i = 0; i < m; i++) {
            printf("CENARIO {%d}\n", i + 1);
            printf("%d - %s\n", i + 1, r[i].nome);
        }
    }

    return 0;
}   