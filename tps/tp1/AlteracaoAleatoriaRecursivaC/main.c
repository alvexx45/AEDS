#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void replace(char *word, int i, char oldChar, char newChar) {
    int len = strlen(word);
    
    if (i < len) {
        if(word[i] == oldChar) {
            word[i] = newChar;
            replace(word, i + 1, oldChar, newChar);
        }
    } 

}

int main () {
    char word[1000];
    srand(4);
    scanf(" %[^\n]", word);
    
    char oldChar = 'a' + (abs(rand()) % 26);
    char newChar = 'a' + (abs(rand()) % 26);

    while (strcmp(word, "FIM")) {   
        
        replace(word, 0, oldChar, newChar);
        printf("%s\n", word);
        
        scanf(" %[^\n]", word);
    }
    
    return 0;
}
