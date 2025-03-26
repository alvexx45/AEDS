import java.util.Scanner;

class Main {
    public static void vencedor(int[] m, int[] l, int n) {
        int somaMark = 0, somaLeti = 0;
        boolean bonusMark = false, bonusLeti = false;

        for (int i = 0; i < n; i++) {
            somaMark += m[i];
            somaLeti += l[i];

            if (i >= 2) {
                if (!bonusMark && !bonusLeti && (m[i] == m[i-1] && m[i] == m[i-2])) {
                    somaMark += 30;
                    bonusMark = true;
                } else if (!bonusMark && !bonusLeti && (l[i] == l[i-1] && l[i] == l[i-2])) {
                    somaLeti += 30;
                    bonusLeti = true;
                }
            }
        }

        if (somaMark > somaLeti) {
            System.out.println("M");
        } else if (somaMark == somaLeti) {
            System.out.println("T");
        } else {
            System.out.println("L");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        while (r != 0) {
            int[] m = new int[r];
            int[] l = new int[r];

            for (int i = 0; i < r; i++) {
                m[i] = sc.nextInt();
            }

            for (int i = 0; i < r; i++) {
                l[i] = sc.nextInt();
            }
            vencedor(m, l, r);

            r = sc.nextInt();
        }

        sc.close();
    }
}