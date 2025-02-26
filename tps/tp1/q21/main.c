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
    char txt[31];
    scanf("%s", txt);

    while(strcmp(txt, "FIM") != 0) {
        inverter(txt, 0, strlen(txt) - 1);
        printf("%s\n", txt);

        scanf("%s", txt);
    }

    return 0;
}