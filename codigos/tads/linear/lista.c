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
    free(lista->elem);
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

void inserirOrdenado(Lista *lista, int x) {
    if (lista->cont >= sizeof(lista)) return;

    int pos;
    for (pos = lista->cont-1; pos >= 0 && lista->elem[pos] > x; pos--) {
        lista->elem[pos+1] = lista->elem[pos];
    }
    lista->elem[pos+1] = x;
    lista->cont++;
}

int removerInicio(Lista *lista) {
    if (lista->cont == 0) return lista->cont;

    int resp = lista->elem[0];
    lista->cont--;

    for (int i = 0; i < lista->cont; i++) {
        lista->elem[i] = lista->elem[i+1];
    }

    return resp;
}

int removerFim(Lista *lista) {
    if (lista->cont == 0) return lista->cont;

    return lista->elem[--lista->cont];
}

int remover(Lista *lista, int pos) {
    if (lista->cont == 0 || (pos < 0 || pos >= lista->cont)) return lista->cont;

    int resp = lista->elem[pos];
    lista->cont--;

    for (int i = pos; i < lista->cont; i++) {
        lista->elem[i] = lista->elem[i+1];
    }

    return resp;
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

    removerFim(lista);
    remover(lista, 1);
    mostrar(lista);

    removerInicio(lista);
    mostrar(lista);

    inserirFim(lista, 10);
    mostrar(lista);

    // printf("Soma: %d", somar());
    // printf("Maior: %d", maior());
    // elementos(lista);

    removerFim(lista);
    removerFim(lista);
    removerFim(lista);

    inserirOrdenado(lista, 12);
    inserirOrdenado(lista, 5);
    inserirOrdenado(lista, 18);
    inserirOrdenado(lista, 9);
    inserirOrdenado(lista, 30);
    mostrar(lista);

    // printf("%d", pesquisar(lista, 6));

    delLista(lista);

    return 0;
}