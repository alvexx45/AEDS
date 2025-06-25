#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int selection(int n, int dna[]) {
    int trocas = 0;

    for (int i = 0; i < n - 1; i++) {
        int menor = i;
        for (int j = i + 1; j < n; j++) {
            if(dna[j] < dna[menor]) {
                menor = j;
            }
        }

        if (menor != i) {
            int tmp = dna[i];
            dna[i] = dna[menor];
            dna[menor] = tmp;
            trocas++;
        }
    }

    return trocas;
}


int main() {
    int t;
    scanf("%d", &t);

    for (int i = 0; i < t; i++) {
        int n;
        scanf("%d", &n);
        int dna[n];
        
        for (int j = 0; j < n; j++) {
            scanf("%d", &dna[j]);
        }

        int trocas = selection(n, dna);
        printf("%d\n", trocas);
    }

    return 0;
}