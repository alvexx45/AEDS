#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int calcular(int h1, int m1, int h2, int m2) {
    int ini = h1 * 60 + m1;
    int fim = h2 * 60 + m2;

    if (fim < ini) fim += 24 * 60;

    return fim - ini;
}

int main() {
    while (true) {
        int h1, m1, h2, m2;
        scanf("%d %d %d %d", &h1, &m1, &h2, &m2);
        if (h1 == 0 && m1 == 0 && h2 == 0 && m2 == 0) break;

        int res = calcular(h1, m1, h2, m2);
        printf("%d\n", res);
    }

    return 0;
}
