#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int padrao(char placa[11]) {
    int res = 0;
    int len = strlen(placa);

    if (len == 8 && placa[3] == '-') {
        for (int i = 0; i < 3; i++) {
            if (!isalpha(placa[i])) {
                i = 3;
            }
        }
    
        for (int i = 4; i < 8; i++) {
            if (!isdigit(placa[i])) {
                i = 8;
            }
        }

        res = 1;
    } 
    else if (len == 7  && isalpha(placa[4])) {
        for (int i = 0; i < 3; i++) {
            if (!isalpha(placa[i])) {
                i = 3;
            }
        }

        for (int i = 3; i < 7; i++) {
            if (!placa[4] && !isdigit(placa[i])) {
                i = 7;
            }
        }

        res = 2;
    }

    return res;
}

int main() {
    char placa[11];

    while (scanf("%s", placa) != EOF) {
        printf("%d\n", padrao(placa));
    }

    return 0;
}