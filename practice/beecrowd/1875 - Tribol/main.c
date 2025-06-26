#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void gols(char m[], char s[], int p) {
    int green = 0, red = 0, blue = 0;

    for (int i = 0; i < p; i++) {
        if (m[i] == 'G' && s[i] == 'R') {
            green += 1;
        } else if (m[i] == 'G' && s[i] == 'B') {
            green += 2;
        } else if (m[i] == 'R' && s[i] == 'B') {
            red += 1;
        } else if (m[i] == 'R' && s[i] == 'G') {
            red += 2;
        } else if (m[i] == 'B' && s[i] == 'G') {
            blue += 1;
        } else if (m[i] == 'B' && s[i] == 'R') {
            blue += 2;
        }
    }

    if (green == red && green == blue && green) {
        printf("trempate\n");
    } else if ((green == red) && (green > 0 || red > 0) || (green == blue) && (green > 0 || blue > 0) || (red == blue) && (red > 0 || blue > 0)) {
        printf("empate\n");
    } else if (green > red && green > blue) {
        printf("green\n");
    } else if (red > green && red > blue) {
        printf("red\n");
    } else if (blue > green && blue > red) {
        printf("blue\n");
    }
}

int main() {
    int c;
    scanf("%d", &c);

    for (int i = 0; i < c; i++) {
        int p;
        scanf("%d", &p);

        char m[p], s[p];
        for (int j = 0; j < p; j++) {
            scanf(" %c %c", &m[j], &s[j]);
        }
        gols(m, s, p);
    }

    return 0;
}