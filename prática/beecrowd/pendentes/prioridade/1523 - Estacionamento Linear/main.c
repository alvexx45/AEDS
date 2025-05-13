#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct Celula {
    int cheg, saida;
    struct Celula *prox;
} Celula;

Celula *topo = NULL;

bool lotado(int n, int k) {
    bool resp = false;



    return resp;
}



int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    while(n != 0 && k != 0) {
        for (int i = 0; i < n; i++) {
            scanf("%d %d", &m[i].cheg, &m[i].saida);
        }
        if (lotado(m, n, k)) {
            printf("Sim\n");
        } else {
            printf("Nao\n");
        }

        scanf("%d %d", &n, &k);
    }

    return 0;
}