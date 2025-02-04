import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] t = new int[4];
        int res = 0;

        for (int i = 0; i < 4; i++) {
            t[i] = sc.nextInt();
            res += t[i];
        }

        res -= 3;
        System.out.print(res);

        sc.close();
    }
}
