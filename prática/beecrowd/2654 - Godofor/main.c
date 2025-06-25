#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[20];
    int power, kills, mortes;
} Deuses;

int compare(const Deuses *a, const Deuses *b) {
	if (a->power != b->power) return b->power - a->power;
	if (a->kills != b->kills) return b->kills - a->kills;
	if (a->mortes != b->mortes) return b->mortes - a->mortes;
	
	return strcmp(a->nome, b->nome);
}

void quicksort(Deuses d[], int esq, int dir) {
	int i = esq, j = dir;
	Deuses pivo = d[(esq+dir)/2];
	
	if (i <= j) {
		while (compare(&d[i], &pivo) < 0) i++;
		while (compare(&d[j], &pivo) > 0) j--;
		
		if (i <= j) {
			Deuses tmp = d[i];
			d[i] = d[j];
			d[j] = tmp;
			i++; j--;
		}
	}
	
	if (esq < j) quicksort(d, esq, j);
	if (i < dir) quicksort(d, i, dir);
}

int main() {
    int n;
    scanf("%d", &n);

    Deuses d[n];
    for (int i = 0; i < n; i++) {
        scanf("%s %d %d %d", d[i].nome, &d[i].power, &d[i].kills, &d[i].mortes);
    }
    quicksort(d, 0, n-1);
    printf("%s", d[0].nome);

    return 0;
}