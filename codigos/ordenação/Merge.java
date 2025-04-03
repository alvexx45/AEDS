import java.util.Scanner;

class Merge {
    public static void mergesort(int[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio+1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    private static void intercalar(int[] array, int esq, int meio, int dir) {
        // definir tamanho dos subarrays
        int sizeEsq = (meio+1) - esq;
        int sizeDir = dir-meio;

        int[] arrayEsq = new int[sizeEsq+1];
        int[] arrayDir = new int[sizeDir+1];

        // sentinela
        arrayEsq[sizeEsq] = arrayDir[sizeDir] = 0x7FFFFFFF;

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.close();
    }
}