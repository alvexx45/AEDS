import java.util.Scanner;

class Main {
    public static String espelhar(int n1, int n2) {
        String normal = "";
        
        for (int i = n1; i <= n2; i++) {
            res += i;
        }

        for (int i = normal.length()-1; i >= 0; i--) {
            invertida += i;
        }

        return normal + invertida;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(espelhar(n1, n2));

        while (sc.hasNextInt()) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            System.out.println(espelhar(n1, n2));
        }

        sc.close();
    }
}