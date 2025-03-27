#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[30];
    int peso, idade;
    float alt;
} Renas;

void sort(Renas r[], int n) {
    for (int i = 0; i < n-1; i++) {
        int maior = i;
        for (int j = i+1; j < n; j++) {
            if (r[maior].peso < r[j].peso) {
                maior = j;
            } else if (r[maior].peso == r[j].peso) {
                if (r[maior].idade > r[j].idade) {
                    maior = j;
                } else if (r[maior].idade == r[j].idade) {
                    if (r[maior].alt < r[j].alt) {
                        maior = j;
                    } else if (r[maior].alt == r[j].alt) {
                        if (strcmp(r[j].nome, r[maior].nome) < 0) {
                            maior = j;
                        }
                    }
                }
            }
        }

        if (maior != i) {
            Renas tmp = r[i];
            r[i] = r[maior];
            r[maior] = tmp;
        }
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

        printf("CENARIO {%d}\n", i + 1);
        for (int k = 0; k < m; k++) {
            printf("%d - %s\n", k + 1, r[k].nome);
        }
    }

    return 0;
}   