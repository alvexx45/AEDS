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

void inserir(Pilha *pilha, int x) {
    if (pilha->cont >= sizeof(pilha)) return;

    pilha->elem[pilha->cont] = x;
    pilha->cont++;
}

int remover(Pilha *pilha) {
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

    inserir(pilha, 3);
    inserir(pilha, 5);
    inserir(pilha, 8);
    inserir(pilha, 9);
    inserir(pilha, 7);
    inserir(pilha, 2);
    mostrar(pilha);

    remover(pilha);
    remover(pilha);
    remover(pilha);
    mostrar(pilha);

    return 0;
}