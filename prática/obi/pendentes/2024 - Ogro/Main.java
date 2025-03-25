import java.util.Scanner;

class Main {
    public static int operacao(int e, int d) {
        int res = 0;
        
        if (e > d) {
            res = e + d;
        } else {
            res = 2 * (d - e);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(operacao(e, d));

        sc.close();
    }
}