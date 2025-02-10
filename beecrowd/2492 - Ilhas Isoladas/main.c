#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char *conectar(int t, char x[][30], char y[][30]) {
    char *res = "Invertible.";

    for (int i = 0; i < t; i++) {
        for (int j = i + 1; j < t; j++) {
            if (strcmp(x[i], x[j]) == 0 && strcmp(y[i], y[j]) != 0) {
                res = "Not a function.";
            }
        }
    }

    for (int i = 0; i < t; i++) {
        for (int j = i + 1; j < t; j++) {
            if (strcmp(y[i], y[j]) == 0 && strcmp(x[i], x[j]) != 0) {
                res = "Not invertible.";
            }
        }
    }
    
    return res;
}

int main() {
    while(true) {
        int t;
        scanf("%d", &t);

        if (t == 0) break;

        char x[t][30], y[t][30];

        for (int i = 0; i < t; i++) {
            scanf(" %30s -> %30s", x[i], y[i]);
        }

        printf("%s\n", conectar(t, x, y));
    }

    return 0;
}