#include <stdio.h>
#include <math.h>

int main() {
    double f, res;
    while (scanf("%lf", &f) != EOF) {
        res = f * 1.0675;
        printf("%.10lf\n", res);
    }

    return 0;
}