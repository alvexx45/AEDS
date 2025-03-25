#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void vencedor(int m[], int l[], int n) {
    int somaMark = 0, somaLeti = 0;
    bool bonusMark = false, bonusLeti = false;

    for (int i = 0; i < n; i++) {
        somaMark += m[i];
        somaLeti += l[i];

        if (i >= 2) {
            if (!bonusMark && !bonusLeti && (m[i] == m[i-1] && m[i] == m[i-2])) {
                somaMark += 30;
                bonusMark == true;
            } else if (!bonusMark && !bonusLeti && (l[i] == l[i-1] && l[i] == l[i-2])) {
                somaLeti += 30;
                bonusLeti = true;
            }
        }
    }

    if (somaMark > somaLeti) {
        printf("M\n");
    } else if (somaMark == somaLeti) {
        printf("T\n");
    } else {
        printf("L\n");
    }
} 

int main() {
    int r;
    scanf("%d", &r);

    while (r != 0) {
        int m[r];
        int l[r];

        for (int i = 0; i < r; i++) {
            scanf("%d", &m[i]);
        }
    
        for (int i = 0; i < r; i++) {
            scanf("%d", &l[i]);
            
        }

        vencedor(m, l, r);
        
        scanf("%d", &r);
    }

    return 0;
}

// 32
// 22

// 44
// 44
 
// 44
// 56