#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Celula {
    int elemento;
    struct Celula *prox;
} Celula;

Celula *novaCelula(int x) {
    Celula *nova = (Celula *) malloc (sizeof(Celula));
    nova->elemento = x;
    nova->prox = NULL;

    return nova;
}

Celula *topo = NULL;

void inserir(int x) {
    Celula *tmp = novaCelula(x);
    tmp->prox = topo;
    topo = tmp;
}

int remover() {
    if (topo == NULL) printf("EMPTY\n");

    int resp = topo->elemento;
    topo = topo->prox;

    return resp;
}

int min() {
    if (topo == NULL) printf("EMPTY\n");

    Celula *min = topo;
    for (Celula *i = topo; i != NULL; i = i->prox) {
        if (i->elemento < min->elemento) min = i;
    }

    return min->elemento;
}

int main() {
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        char input[11];
        int v = 0;
        scanf("%s", input);

        if (strcmp(input, "PUSH") == 0) {
            scanf("%d", &v);
            inserir(v);
        } else if (strcmp(input, "POP") == 0) {
            remover();
        } else if (strcmp(input, "MIN") == 0) {
            printf("%d\n", min());
        }
    }

    while (topo != NULL) {
        Celula *tmp = topo;
        topo = topo->prox;
        free(tmp);
    }

    return 0;
}