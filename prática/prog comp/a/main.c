#include <stdio.h>
#include <stdbool.h>

int main() {
    int t;
    scanf("%d", &t);

    while (t--) {
        int n, i, j;
        bool desconhecido[10] = {false};
        scanf("%d", &n);

        for (i = 0; i < n; i++) {
            int d;
            scanf("%d", &d);
            desconhecido[d] = true;
        }

        int count = 0;

        for (i = 0; i < 10; i++) {
            if (desconhecido[i]) continue;
            for (j = i + 1; j < 10; j++) {
                if (desconhecido[j]) continue;
                count += 6;
            }
        }

        printf("%d\n", count);
    }

    return 0;
}
