#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int somadig(int num) {
    int soma = 0;
    while (num > 0) {
        soma += num % 10;
        num /= 10;
    }

    return soma;
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    int flores[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &flores[i]);
    }

    int resp = 0;
    for (int i = 1; i <= k; i++) {
        int maior = 0;
        for (int j = 1; j < n; j++) {
            if (flores[j] > flores[maior]) {
                maior = j;
            }
        }

        int coleta = somadig(flores[maior]);
        resp = coleta;

        flores[maior] -= coleta;

        if (i == k) i = n;
    }

    printf("%d\n", resp);

    return 0;
}