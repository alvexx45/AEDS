#include <stdio.h>
#include <string.h>
#include <stdbool.h>

// função que verifica se uma string é um palíndromo
bool validPalindromo(const char *txt) {
    int i = 0;
    int j = strlen(txt) - 1;

    while (i < j) {
        if (txt[i] != txt[j]) {
            return false;
        }
        i++;
        j--;
    }

    return true;
}

int main() {
    char texto[1000];
    bool flag = false;

    while (!flag) {
        // utilização do fgets por ineficácia do scanf
        if (fgets(texto, sizeof(texto), stdin) != NULL) {
            // remove o caractere de nova linha
            texto[strcspn(texto, "\n")] = '\0';

            // verifica se é necessário encerrar o programa
            if (strlen(texto) == 3 && texto[0] == 'F' && texto[1] == 'I' && texto[2] == 'M') {
                flag = true;
            } else {
                // chamada do método
                if (validPalindromo(texto)) {
                    printf("SIM\n");
                } else {
                    printf("NAO\n");
                }
            }
        }
    }


    return 0;
}

