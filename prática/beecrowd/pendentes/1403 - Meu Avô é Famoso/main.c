#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int n, m;

    while (n != 0 && m != 0) {
        scanf("%d %d", &n, &m);
        
        int matriz[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                scanf("%d", matriz[i][j]);
            }
        }
    }

    return 0;
}