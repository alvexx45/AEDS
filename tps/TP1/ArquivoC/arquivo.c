#include <stdio.h>
#include <stdlib.h>

int main() {
    // abre o arquivo para escrita em modo binário
    FILE *file = fopen("numeros.txt", "wb");
    int n, numInt;
    double num;

    scanf("%d", &n);
  
    // escreve os números como double
    for(int i = 0 ; i < n ; i++) {    
        scanf("%lf", &num);    
        fwrite(&num, sizeof(double), 1, file);
    }

    fclose(file);

    // reabre para leitura em modo binário
    file = fopen("numeros.txt", "rb");
    
    // move ponteiro para o final
    fseek(file, 0, SEEK_END);
    // obtém posição atual do ponteiro
    long pos = ftell(file);
    // retorna ponteiro para o início
    fseek(file, 0, SEEK_SET);

    while(pos >= sizeof(double)) {
        pos -= sizeof(double);
        fseek(file, pos, SEEK_SET);
        fread(&num, sizeof(double), 1, file);
        
        numInt = (int)num;

        if (numInt - num == 0) {
            // imprime como int
            printf("%d\n", numInt);
        } else {
            // imprime como double
            printf("%g\n", num);
        }
    }

    fclose(file);

    return 0;
}