#include <stdio.h>
#include <string.h>

int contar(char *vogais, char *frase) {
    int cont = 0;

    for (int i = 0; vogais[i] != '\0'; i++) {
        for (int j = 0; vogais[j] != '\0'; j++) {
            if (vogais[i] == vogais[j]) {
                cont++;
            }
        }
    }

    return cont;
}

int main() {
    char vogais[31];
    char frase[51];

    while (scanf("%s", vogais) != EOF) {
        scanf(" %[^\n]", frase);
        printf("%d\n", contar(vogais, frase));
    }

    return 0;
}