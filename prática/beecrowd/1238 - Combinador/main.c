#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void combinar(char *str1, char *str2) {
    char res[41] = "";
    int i = 0, j = 0, k = 0;

    while (i < strlen(str1) || j < strlen(str2)) {
        if (i < strlen(str1)) res[k++] = str1[i++];
        if (j < strlen(str2)) res[k++] = str2[j++];
    }
    
    res[k] = '\0';
    printf("%s\n", res);
}

int main() {
    char str1[21], str2[21];
    int n;

    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%s %s", str1, str2);
        combinar(str1, str2);
    }

    return 0;
} 