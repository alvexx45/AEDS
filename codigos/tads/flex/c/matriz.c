#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <celulamat.h>

CelulaMat *inicio = NULL;
int linhas, colunas;

CelulaMat *createColuna(int linhas) {
    CelulaMat *i = novaCelula();
    CelulaMat *tmp = i;

    for (int j = 0; j < linhas-1; j++) {
        CelulaMat *nova = novaCelula();
        tmp->inf = nova;
        nova->sup = tmp;
        
        tmp = nova;
    }

    return i;
}

void addColuna() {
    CelulaMat *i;
    for (i = inicio; i->dir != NULL; i = i->dir);
    for (CelulaMat *j = createColuna(linhas); j != NULL; j = j->inf) {
        i->dir = j;
        j->esq = i;

        i = i->inf;
    }
    colunas++;
}

void removerColuna() {
    if (colunas == 0) {
        return;
    } else if (colunas == 1) {
        inicio == NULL;
        colunas--;
    } else {
        CelulaMat *i;
        for (i = inicio; i->dir != NULL; i = i->dir);
        while (i != NULL) {
            i->esq = i->esq->dir = NULL;
            i = i->inf;
        }
        colunas--;
    }
}

void removerLinha() {
    if (linhas == 0) {
        return;
    } else if (linhas == 1) {
        inicio = NULL;
        linhas--;
    } else {
        CelulaMat *i;
        for (i = inicio; i->inf != NULL; i = i->inf);
        while (i != NULL) {
            i->sup = i->sup->inf = NULL;
            i = i->dir;
        }
        linhas--;
    }
}

void imprimir() {
    if (inicio == NULL) return;

    for (CelulaMat *i = inicio; i != NULL; i = i->inf) {
        for (CelulaMat *j = i; j != NULL; j = j->dir) {
            printf("%d ", &j->elemento);
        }
    }
    printf("\n");
}