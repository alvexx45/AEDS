#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int *elem;
    int cont;
} Pilha;

Pilha *newPilha(int size) {
    Pilha *pilha;
    pilha = (Pilha *)malloc(sizeof(Pilha));
    pilha->elem = (int *)malloc(size * sizeof(int));
    pilha->cont = 0;

    return pilha;
}

void delPilha(Pilha *pilha) {
    free(pilha);
}

void empilhar(Pilha *pilha, int x) {
    if (pilha->cont >= sizeof(pilha)) return;

    pilha->elem[pilha->cont] = x;
    pilha->cont++;
}

int desempilhar(Pilha *pilha) {
    if (pilha->cont == 0) return pilha->cont;

    return pilha->elem[--pilha->cont];
}

void mostrar(Pilha *pilha) {
    for (int i = 0; i < pilha->cont; i++) {
        printf("%d ", pilha->elem[i]);
    }
    printf("\n");
}

int main() {
    Pilha *pilha = newPilha(6);

    empilhar(pilha, 3);
    empilhar(pilha, 5);
    empilhar(pilha, 8);
    empilhar(pilha, 9);
    empilhar(pilha, 7);
    empilhar(pilha, 2);
    mostrar(pilha);

    desempilhar(pilha);
    desempilhar(pilha);
    desempilhar(pilha);
    mostrar(pilha);

    return 0;
}