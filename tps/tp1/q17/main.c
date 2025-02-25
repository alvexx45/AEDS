#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isPalindrome(const char* str, int start, int end) {
    // se a posição atingir ou ultrapassar a metade da string, é um palíndromo
    if (start >= end) {
        return true;
    }

    // verifica se os caracteres nas posições simétricas são iguais
    if (str[start] != str[end]) {
        return false;
    }

    // chamada recursiva
    return isPalindrome(str, start + 1, end - 1);
}

int main() {
    char inputString[1000];
    
    while (true) {

        scanf(" %[^\n]", inputString);

        if (strcmp(inputString, "FIM") == 0) {
            return 0;
        }

        int length = strlen(inputString);
        
        if (isPalindrome(inputString, 0, length - 1)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}
