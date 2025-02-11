#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int k = 1;
    int p, s;
    scanf("%d %d", &p, &s);

    while (p != 0 && s != 0) {
        int u[s], v[s];
        for (int i = 0; i < s; i++) {
            scanf("%d %d", &u[i], &v[i]);
        }
        intervalos(u, v);
        printf("Teste %d");
        k++;
    }


    return 0;
}