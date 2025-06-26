#include <stdio.h>
#include <stdbool.h>

int main() {
    int p, s;
    int testes = 0;

    while (true) {
        scanf("%d %d", &p, &s);
        if (p == 0 && s == 0) break;

        testes++;

        int u, v;
        int cU = -1, cV = -1;

        printf("Teste %d\n", testes);
        
        for (int i = 0; i < s; i++) {
            scanf("%d %d", &u, &v);

            if (cU == -1 || u > cV) {
                if (cU != -1) {
                    printf("%d %d\n", cU, cV);
                }
                cU = u;
                cV = v;
            } else {
                if (v > cV) {
                    cV = v;
                }
            }
        }
        
        if (cU != -1) {
            printf("%d %d\n", cU, cV);
        }
    }

    return 0;
}