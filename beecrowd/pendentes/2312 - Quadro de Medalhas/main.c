#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[21];
    int ouro, prata, bronze;
} Pais;

void sort(Pais p[], int n) {
    for (int i = 0; i < n-1; i++) {
        int maior = i;
        for (int j = i+1; j < n; j++) {
            if (p[j].ouro > p[maior].ouro) {
                maior = j;
            } else if (p[j].ouro == p[maior].ouro) {
                if (p[j].prata > p[maior].prata) {
                    maior = j;
                }
            } else if (p[j].prata == p[maior].prata) {
                if (p[j].bronze > p[maior].bronze) {
                    maior = j;
                }
            } else if (p[j].bronze == p[maior].bronze) {
                if (strcmp(p[j].nome, p[maior].nome) < 0) {
                    maior = j;
                }
            }
        }
        
        Pais tmp = p[i];
        p[i] = p[maior];
        p[maior] = tmp;
    }
}

int main() {
    int n;
    scanf("%d", &n);

    Pais p[n];

    for (int i = 0; i < n; i++) {
        scanf("%s %d %d %d", p[i].nome, &p[i].ouro, &p[i].prata, &p[i].bronze);
    }
    sort(p, n);

    for (int i = 0; i < n; i++) {
        printf("%s %d %d %d\n", p[i].nome, p[i].ouro, p[i].prata, p[i].bronze);
    }

    return 0;
}