#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *espelhar(int n1, int n2) {
    char normal[21] = "";
    for (int i = n1; i <= n2; i++) {
        sprintf(normal + strlen(normal), "%d", i);
    }

    char invertida[21] = "";
    for (int i = strlen(normal)-1, j = 0; i >= 0; i--, j++) {
        invertida[j] = normal[i];
    }

    static char result[42];
    strcpy(result, normal);
    strcat(result, invertida);

    return result;
}

int main() {
    int n1, n2;
    
    while (scanf("%d %d", &n1, &n2) != EOF) {
        printf("%s\n", espelhar(n1, n2));
    }

    return 0;
}