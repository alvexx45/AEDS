#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int operacao(int e, int d) {
    int res = 0;

    if (e > d) {
        res = e + d;
    } else {
        res = 2 * (d - e);
    }

    return res;
}

int main() {
    int e, d;
    scanf("%d", &e);
    scanf("%d", &d);

    printf("%d", operacao(e, d));

    return 0;
}