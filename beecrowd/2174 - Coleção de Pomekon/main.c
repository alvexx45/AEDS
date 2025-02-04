#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main() {

    char *pomedex[151] = {NULL};
    int count = 0;

    int n;
    scanf("%d", &n);


    for (int i = 0; i < n; i++) {
        bool added = false;
        char pmk[30];
        scanf("%s", pmk);

        for (int j = 0; j < count; j++) {
            if (strcmp(pomedex[j], pmk) == 0) {
                added = true;
                j = count;
            }
        }

        if (!added && count < 151) {
            pomedex[count] = malloc(strlen(pmk) + 1);
            
            if (pomedex[count] == NULL) {
                return 1;
            }

            strcpy(pomedex[i], pmk);
            count++;
        }
    }

    int resto = 151 - count;
    printf("Falta(m) %d pomekon(s).\n", resto);


    return 0;
}