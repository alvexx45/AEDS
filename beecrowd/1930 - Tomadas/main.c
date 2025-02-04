#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int t[4];
    int res = 0;

    for (int i = 0; i < 4; i++) {
        scanf("%d", &t[i]);
        res += t[i];
    }

    res -= 3;
    printf("%d", res);

    return 0;
}