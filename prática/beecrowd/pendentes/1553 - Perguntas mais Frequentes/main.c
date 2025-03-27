#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int frequentes(int perg[], int n, int k) {
    int res = 0;
    bool contado[101] = {false};

    for (int i = 0; i < n; i++) {
        if (!contado[perg[i]]) {
            int cont = 0;
            for (int j = 0; j < n; j++) {
                if (perg[i] == perg[j]) {
                    cont++;
                }
            }        
            if (cont >= k) {
                res++;
                contado[perg[i]] = true;
            }
        }
    }

    return res;
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    while (n != 0 && k != 0) {
        int perg[n];

        for (int i = 0; i < n; i++) {
            scanf("%d", &perg[i]);
        }
        printf("%d\n", frequentes(perg, n, k));

        scanf("%d %d", &n, &k);
    }

    return 0;
}