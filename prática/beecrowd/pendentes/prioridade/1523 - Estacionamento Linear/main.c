#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct Celula {
    int saida;
    struct Celula *prox;
} Celula;

Celula *novaCelula(int x) {
    Celula *nova = (Celula *) malloc (sizeof(Celula));
    nova->saida = x;
    nova->prox = NULL;
    
    return nova;
}

Celula *topo = NULL;
int tamanho = 0;

void inserir(int x) {
    Celula *tmp = novaCelula(x);
    tmp->prox = topo;
    topo = tmp;
    tamanho++;
}

int remover() {
    if (topo == NULL) printf("pilha vazia");

    int resp = topo->saida;
    topo = topo->prox;
    tamanho--;

    return resp;
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    while(n != 0 && k != 0) {
        bool livre = true;

        for (int i = 0; i < n; i++) {
            int cheg, saida;
            scanf("%d %d", &cheg, &saida);

            while (topo != NULL && cheg >= topo->saida) remover();

            if (topo != NULL && saida > topo->saida) livre = false;
            if (tamanho >= k) livre = false;
            if (livre) inserir(saida);
        }

        if (livre) {
            printf("Sim\n");
        } else {
            printf("Nao\n");
        }

        while (topo != NULL) {
            Celula *tmp = topo;
            topo = topo->prox;
            free(tmp);
        }

        scanf("%d %d", &n, &k);
    }

    return 0;
}