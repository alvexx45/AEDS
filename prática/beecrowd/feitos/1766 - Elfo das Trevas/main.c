#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[30];
    int peso, idade;
    float alt;
} Renas;

/*
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
*/

void sort(Renas r[], int n) {
    for (int i = 0; i < n-1; i++) {
        int maior = i;
        for (int j = i+1; j < n; j++) {
            if (r[j].peso > r[maior].peso || 
                (r[j].peso == r[maior].peso && r[j].idade < r[maior].idade) || 
                (r[j].idade == r[maior].peso && r[j].alt > r[maior].alt) || 
                (r[j].alt == r[maior].alt && strcmp(r[j].nome, r[maior].nome) < 0)) {
                maior = j;
            }
        }
        Renas tmp = r[i];
        r[i] = r[maior];
        r[maior] = tmp;
    }
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
        sort(r, n);
        // qsort(r, n, sizeof(Renas), compare);

        printf("CENARIO {%d}\n", i + 1);
        for (int k = 0; k < m; k++) {
            printf("%d - %s\n", k + 1, r[k].nome);
        }
    }

    return 0;
}   