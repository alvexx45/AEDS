#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void inverter(char *str, int inicio, int fim) {
    if (inicio >= fim) {
        return;
    }

    char tmp = str[inicio];
    str[inicio] = str[fim];
    str[fim] = tmp;

    inverter(str, inicio + 1, fim - 1);
} 

int main() {
    char str[31];
    scanf("%s", str);

    while(strcmp(str, "FIM") != 0) {
        inverter(str, 0, strlen(str) - 1);
        printf("%s\n", str);

        scanf("%s", str);
    }

    return 0;
}