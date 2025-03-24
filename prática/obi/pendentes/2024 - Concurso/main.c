#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int corte(int array[], int n, int k) {
    for (int i = 0; i < k; i++) {
        int maior = i;
        for (int j = i+1; j < n; j++) {
            if (array[j] > array[maior]) {
                maior = j;
            }
        }
        int tmp = array[i];
        array[i] = array[maior];
        array[maior] = tmp;
    }

    return array[k-1];
}

int main() {

    int n, k;
    while(scanf("%d %d", &n, &k) != EOF) {
        int array[n];

        for (int i = 0; i < n; i++) {
            scanf("%d", &array[i]);
        }
        printf("%d\n", corte(array, n, k));    
    }

    return 0;
}

// 3 1
// 92 83 98
// 98
// 
// 4 2
// 1 2 3 4
// 3 4
// 3
// 
// 5 3
// 20 20 10 20 30
// 30 20 20
// 20
// 
// 10 5
// 1 2 2 1 2 2 1 1 1 1
// 2 2 2 2 1
// 1
