#include <stdio.h>
#include <stdbool.h>

int frequentes(int p[], int n, int k) {
    int res = 0;
    bool contado[101] = {false};

    for (int i = 0; i < n; i++) {
        int cont = 0;
        if (!contado[p[i]]) {
            for (int j = 0; j < n; j++) {
                if (p[i] == p[j]) {
                    cont++;
                }
            }
        }

        if (cont >= k) {
            res++;
            contado[p[i]] = true;
        }
    }
        for (int j = 0; j < n; j++) {

        }

    return res;
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    while (n != 0 && k != 0) {
        int p[n];

        for (int i = 0; i < n; i++) {
            scanf("%d", &p[i]);
        }
        printf("%d\n", frequentes(p, n, k));
        
        scanf("%d %d", &n, &k);
    }

    return 0;
}