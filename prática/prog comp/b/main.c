#include <stdio.h>
#include <string.h>

int main() {
    int T;
    scanf("%d", &T);
    
    while (T--) {
        int n;
        scanf("%d", &n);
        
        char red[1001], blue[1001];
        scanf("%s", red);
        scanf("%s", blue);

        int redWins = 0, blueWins = 0;

        for (int i = 0; i < n; i++) {
            if (red[i] > blue[i]) {
                redWins++;
            } else if (red[i] < blue[i]) {
                blueWins++;
            }
        }

        if (redWins > blueWins) {
            printf("RED\n");
        } else if (blueWins > redWins) {
            printf("BLUE\n");
        } else {
            printf("EQUAL\n");
        }
    }

    return 0;
}
