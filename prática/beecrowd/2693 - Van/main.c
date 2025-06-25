#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[30];
    char dir;
    int dist;
} Van;

/* int compare(const void *a, const void *b) {
    Van *v1 = (Van *)a;
    Van *v2 = (Van *)b;

    if (v1->dist != v2->dist)
        return v1->dist - v2->dist;
        
    return strcmp(v1->nome, v2->nome);
} */

void sort(Van v[], int n) {
    for (int i = 0; i < n-1; i++) {
        int menor = i;
        for (int j = i+1; j < n; j++) {
            if(v[j].dist < v[menor].dist ||
                (v[j].dist == v[menor].dist && v[j].dir < v[menor].dir) ||
                (v[j].dir == v[menor].dir && strcmp(v[j].nome, v[menor].nome) < 0)){
                    menor = j;
                }
        }
        Van tmp = v[i];
        v[i] = v[menor];
        v[menor] = tmp;
    }
}

int main() {
    int n;
    scanf("%d", &n);

    Van v[n];

    for (int i = 0; i < n; i++) {
        scanf("%s %c %d", v[i].nome, &v[i].dir, &v[i].dist);
    }
    sort(v, n);
    // qsort(v, n, sizeof(Van), compare);

    for (int i = 0; i < n; i++) {
        printf("%s\n", v[i].nome);
    }

    return 0;
}