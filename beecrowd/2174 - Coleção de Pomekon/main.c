#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int compare(const void *a, const void *b) {
    return strcmp(*(const char **)a, *(const char **)b);
}

int main() {

    char *pomedex[151] = {NULL};
    int count = 0;

    int n;
    scanf("%d", &n);


    for (int i = 0; i < n; i++) {
        char pmk[30];
        scanf("%s", pmk);

        char *key = pmk;
        if (bsearch(&key, pomedex, count, sizeof(char *), compare) == NULL) {
            if (count < 151) {
                pomedex[count] = malloc(strlen(pmk) + 1);
                strcpy(pomedex[count], pmk);
                count++;

                qsort(pomedex, count, sizeof(char *), compare);
            }
        }
    }

    printf("Falta(m) %d pomekon(s).\n", 151 - count);

    for (int i = 0; i < count; i++) {
        free(pomedex[i]);
    }

    return 0;
}