#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int soma(int num) {
    if (num == 0) return 0;

    return (num % 10) + soma(num / 10);
}

int main() {
    char entrada[10];

    scanf("%s", entrada);

    while(strcmp(entrada, "FIM") != 0) {
        int num = atoi(entrada);
        printf("%d\n", soma(num));

        getchar() != '\n';
        scanf("%s", entrada);
    }

    return 0;
}