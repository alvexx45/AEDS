#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int elemento;
    struct Celula *prox;
} Celula;

Celula *inicio, *fim;

void meiose() {
    Celula *i;
    for (i = inicio; i != NULL; i = i->prox) {
        int x = i->elemento/2;
        i->elemento = x;
        Celula *nova = (Celula *) malloc (sizeof(Celula));
        nova->elemento = x;
        nova->prox = i->prox;
        i->prox = nova;

        if (i == fim) {
            fim = nova;
        }
    }
}