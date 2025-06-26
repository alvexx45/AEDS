#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int diamantes(char *str) {
    int cont = 0;
    int res = 0;

    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == '<') {
            cont++;
        } else if (str[i] == '>' && cont > 0) {
            cont--;
            res++;
        }
    }

    return res; 
}

int main() {
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        char str[100];
        scanf("%s", str);

        int res = diamantes(str);
        printf("%d\n", res);
    }

    return 0;
}