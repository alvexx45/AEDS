#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct No {
    char nome[31];
    char opcao[4];
    struct No *esq, *dir;
} No;

No *novoNo(char *nome, char *opcao) {
    No *novo = (No *)malloc(sizeof(No));
    strcpy(novo->nome, nome);
    strcpy(novo->opcao, opcao);

    novo->esq = novo->dir = NULL;
    return novo;
}

No *inserir(No *raiz, char *nome, char *opcao) {
    if (raiz == NULL) {
        return novoNo(nome, opcao);
    }
    int cmp = strcmp(nome, raiz->nome);
    if (cmp < 0) {
        raiz->esq = inserir(raiz->esq, nome, opcao);
    } else if (cmp > 0) {
        raiz->dir = inserir(raiz->dir, nome, opcao);
    }

    return raiz;
}

void imprimirEmOrdem(No *raiz) {
    if (raiz != NULL) {
        imprimirEmOrdem(raiz->esq);
        printf("%s\n", raiz->nome);
        imprimirEmOrdem(raiz->dir);
    }
}

No *buscarAmigo(No *raiz, No *melhor, int *ordem) {
    if (raiz == NULL) {
        return melhor;
    }
    if (melhor == NULL || strlen(raiz->nome) > strlen(melhor->nome) || (strlen(raiz->nome) == strlen(melhor->nome) && *ordem == 0)) {
        melhor = raiz;
        *ordem = 1;
    }
    melhor = buscarAmigo(raiz->esq, melhor, ordem);
    melhor = buscarAmigo(raiz->dir, melhor, ordem);
    return melhor;
}

int main() {
    No *raizYes = NULL, *raizNo = NULL;
    char nome[31], opcao[4];
    
    while (scanf("%s", nome) && strcmp(nome, "FIM") != 0) {
        scanf("%s", opcao);
        if (strcmp(opcao, "YES") == 0) {
            raizYes = inserir(raizYes, nome, opcao);
        } else {
            raizNo = inserir(raizNo, nome, opcao);
        }
    }
    
    imprimirEmOrdem(raizYes);
    imprimirEmOrdem(raizNo);
    
    printf("\nAmigo do Habay:\n");
    int ordem = 0;
    No *escolhido = buscarAmigo(raizYes, NULL, &ordem);
    printf("%s\n", escolhido->nome);
    
    return 0;
}