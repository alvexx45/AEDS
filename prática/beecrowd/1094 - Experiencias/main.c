#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int qtd;
    char tipo;
} Cobaias;

int main() {
    int n;
    scanf("%d", &n);

    Cobaias c[n];

    int coelhos = 0, ratos = 0, sapos = 0;
    for (int i = 0; i < n; i++) {
        scanf("%d %c", &c[i].qtd, &c[i].tipo);
        
        if (c[i].tipo == 'C') {
            coelhos += c[i].qtd;
        } else if (c[i].tipo == 'R') {
            ratos += c[i].qtd;
        } else {
            sapos += c[i].qtd;
        }
    }
    int soma = coelhos + ratos + sapos;
    
    double pCoelhos = (coelhos * 100.0) / soma;
    double pRatos = (ratos * 100.0) / soma;
    double pSapos = (sapos * 100.0) / soma;

    printf("Total: %d cobaias\n", soma);
    printf("Total de coelhos: %d\n", coelhos);
    printf("Total de ratos: %d\n", ratos);
    printf("Total de sapos: %d\n", sapos);
    printf("Percentual de coelhos: %.2f %%\n", pCoelhos);
    printf("Percentual de ratos: %.2f %%\n", pRatos);
    printf("Percentual de sapos: %.2f %%\n", pSapos);

    return 0;
}