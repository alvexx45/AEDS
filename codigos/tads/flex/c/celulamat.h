#include <stdlib.h>

typedef struct {
    int elemento;
    struct Celula *esq, *dir, *inf, *sup;
} CelulaMat;

CelulaMat *novaCelula(int elemento) {
    CelulaMat *nova = (CelulaMat *) malloc(sizeof(CelulaMat));
    nova->elemento = elemento;
    nova->esq = NULL;
    nova->dir = NULL;
    nova->inf = NULL;
    nova->sup = NULL;

    return nova;
}