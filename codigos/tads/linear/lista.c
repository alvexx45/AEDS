#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int *elem;
    int cont;
} Lista;

Lista *newLista(int size) {
    Lista *lista;
    lista = (Lista *)malloc(sizeof(Lista));
    lista->elem = (int *)malloc(size * sizeof(int));
    lista->cont = 0;

    return lista;
}

void delLista(Lista *lista) {
    free(lista);
}

void inserirInicio(Lista *lista, int x) {
    if (lista->cont >= sizeof(lista)) return;

    for (int i = lista->cont; i > 0; i--) {
        lista->elem[i] = lista->elem[i-1];
    }
    lista->elem[0] = x;
    lista->cont++;
}

void inserirFim(Lista *lista, int x) {
    if (lista->cont >= sizeof(lista)) return;

    lista->elem[lista->cont] = x;
    lista->cont++;
}

void inserir(Lista *lista, int x, int pos) {
    if (lista->cont >= sizeof(lista)) return;

    for (int i = lista->cont; i > pos; i--) {
        lista->elem[i] = lista->elem[i-1];
    }
    lista->elem[pos] = x;
    lista->cont++;
}

void mostrar(Lista *lista) {
    for (int i = 0; i < lista->cont; i++) {
        printf("%d ", lista->elem[i]);
    }
    printf("\n");
}

int main() {
    Lista *lista = newLista(6);

    inserirFim(lista, 13);
    inserirInicio(lista, 10);
    inserir(lista, 40, 1);
    inserirFim(lista, 28);
    inserir(lista, 12, 2);
    mostrar(lista);

    return 0;
}