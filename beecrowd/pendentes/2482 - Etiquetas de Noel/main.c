#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char lingua[21];
    char msg[21];
} Xmas;

typedef struct {
    char nome[31];
    char idioma[21];
} Pessoa;

void verificar(Xmas x[], Pessoa p[], int n, int m) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (strcmp(x[j].lingua, p[i].idioma) == 0) {
                printf("%s\n", p[i].nome);
                printf("%s\n", x[j].msg);
                j = n;
            }
        }
    }
}

int main() {
    int n;
    scanf("%d", &n);
    Xmas x[n];

    for (int i = 0; i < n; i++) {
        scanf(" %[^\n]", x[i].lingua);
        scanf(" %[^\n]", x[i].msg);
    }

    int m;
    scanf("%d", &m);
    Pessoa p[m];

    for (int i = 0; i < m; i++) {
        scanf(" %[^\n]", p[i].nome);
        scanf(" %[^\n]", p[i].idioma);
    }
    verificar(x, p, n, m);

    return 0;
}