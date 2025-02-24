#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[31];
    char cor[21];
    char tam;
} Confeccao;

int compare(const void *a, const void *b) {
    Confeccao *c1 = (Confeccao *)a;
    Confeccao *c2 = (Confeccao *)b;

    int cmp = strcmp(c1->cor, c2->cor);
    if (cmp != 0) {
        return cmp;
    }

    if (c1->tam != c2->tam) {
        if (c1->tam == 'P') return -1;
        if (c2->tam == 'P') return 1;
        if (c1->tam == 'M') return -1;
        if (c2->tam == 'M') return 1;
    }

    return strcmp(c1->nome, c2->nome);
}

int main() {
    int n;
    scanf("%d", &n);

    while (n != 0) {
        Confeccao c[n];

        for (int i = 0; i < n; i++) {
            getchar();
            fgets(c[i].nome, 31, stdin);
            c[i].nome[strcspn(c[i].nome, "\n")] = '\0';
            scanf("%s %c", c[i].cor, &c[i].tam);
        }
        qsort(c, n, sizeof(Confeccao), compare);
        
        for (int i = 0; i < n; i++) {
            printf("%s %c %s\n", c[i].cor, c[i].tam, c[i].nome);
        }
        if (n > 0) printf("\n");

        scanf("%d", &n);
    }

    return 0;
}