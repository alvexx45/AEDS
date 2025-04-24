#include <stdio.h>

int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);

    double p_s = (double)a / b;
    double p_z = (double)c / d;

    double prob = p_s / (1 - (1 - p_s) * (1 - p_z));

    printf("%.12lf\n", prob);
    return 0;
}
