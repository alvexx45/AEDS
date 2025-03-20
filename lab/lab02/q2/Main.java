import java.util.Scanner;

class Main {
    public static String espelhar(int n1, int n2) {
        String res = "";
        
        for (int i = n1; i <= n2; i++) {
            res += Integer.toString(i);
        }

        for (int i = n2; i >= n1; i--) {
            String inverter = new StringBuilder(Integer.toString(i)).reverse().toString();
            res += inverter;
        }

        return res;
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