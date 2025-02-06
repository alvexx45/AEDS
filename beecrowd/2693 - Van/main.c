#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[30];
    char dir;
    int dist;
} Van;

int main() {
    int n;
    scanf("%d", &n);

    Van v[n];

    for (int i = 0; i < n; i++) {
        scanf("%s %c %d", v[i].nome, v[i].dir, &v[i].dist);
    }
    qsort()

    return 0;
}