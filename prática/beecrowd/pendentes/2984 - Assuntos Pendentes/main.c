#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int assuntos(char str[]) {
    int cont = 0;

    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == '(') {
            cont++;
        } else if (str[i] == ')' && cont > 0) {
            cont--;
        }
    }

    return cont;
}

int main() {
    char str[21];

    while(scanf("%s", str) != EOF) {
        int res = assuntos(str);
        if (res == 0) {
            printf("Partiu RU!\n");
        } else {
            printf("Ainda temos %d assunto(s) pendente(s)!\n", res);
        }
    }

    return 0;
}