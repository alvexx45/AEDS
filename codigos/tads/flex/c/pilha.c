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

int main() {

    return 0;
}