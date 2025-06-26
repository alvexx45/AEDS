#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <celula.h>

Celula *topo = NULL;

void inserir(int x) {
    Celula *tmp = novaCelula(x);
    tmp->prox = topo;
    topo = tmp;
    tmp = NULL;
}

int remover() {
    if (topo == NULL) exit(1);
    
    int resp = topo->elemento;
    
    Celula *tmp = topo;
    topo = topo->prox;
    free(tmp);

    return resp;
}

void mostrar(Celula *i) {
    if (i == NULL) return;
    
    printf("%d", &i->prox);
    mostrar(i->prox);
}

int soma() {
    int res = 0;

    for (Celula *i = topo; i != NULL; i = i->prox) {
        if (i->elemento > res) res = i->elemento;
    }

    return res;
}

int somaRec(Celula *i) {
    if (i == NULL) return 0;

    return i->elemento + somaRec(i->prox);
}

int main() {

    return 0;
}