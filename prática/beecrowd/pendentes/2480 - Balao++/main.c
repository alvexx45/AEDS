#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int r, l;
    scanf("%d %d", &r, &l);

    float v = (4.0/3.0) * (3.1415 * (r*r*r));
    float res = l/v;

    printf("%.0f\n", res);

    return 0;
}
