import java.util.Scanner;

class Main {
    public static int calcular(int h1, int m1, int h2, int m2) {
        int ini = h1 * 60 + m1;
        int fim = h2 * 60 + m2;

        if (fim < ini) fim += 24 * 60;
        
        return fim - ini;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();

            if (h1 == 0 && m1 == 0 && h2 == 0 && m2 == 0) break;

            int res = calcular(h1, m1, h2, m2);
            System.out.println(res);

        }
        
        sc.close();
    }
}