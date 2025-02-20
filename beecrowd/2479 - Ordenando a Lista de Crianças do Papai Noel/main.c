#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void selection(int n, char nomes[][31]) {
    for (int i = 0; i < n - 1; i++) {
        int menor = i;
        for (int j = i + 1; j < n; j++) {
            if (strcmp(nomes[j], nomes[menor]) < 0) {
                menor = j;
            }
        }
        
        if (menor != i) {
            char tmp[31];
            strcpy(tmp, nomes[i]);
            strcpy(nomes[i], nomes[menor]);
            strcpy(nomes[menor], tmp);
        }
    }
}

int main() {
    int n;
    scanf("%d", &n);

    char comp;
    char nomes[n][31];
    int b = 0, m = 0;

    for (int i = 0; i < n; i++) {
        scanf(" %c %s", &comp, nomes[i]);
        if (comp == '+') b++;
        if (comp == '-') m++;
    }
    selection(n, nomes);

    for (int i = 0; i < n; i++) {
        printf("%s\n", nomes[i]);
    }
    printf("Se comportaram: %d | Nao se comportaram: %d", b, m);

    return 0;
}