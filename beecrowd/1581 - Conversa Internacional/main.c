#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char *conversa(char idiomas[][20], int k) {
    char *fst = idiomas[0];
    bool same = true;

    for (int i = 1; i < k; i++) {
        if (strcmp(idiomas[i], fst) != 0) {
            same = false;
            i = k;
        }
    }

    return same ? fst : "ingles";
}

int main() {
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        int k;
        scanf("%d", &k);
        char idiomas[k][20];
        
        for (int j = 0; j < k; j++) {
            scanf("%s", idiomas[j]);
        }

        char *res = conversa(idiomas, k);
        printf("%s\n", res);
    }

    return 0;
}