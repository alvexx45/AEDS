import java.util.Scanner;

class Main {
    public static int diamantes(String str) {
        int cont = 0;
        int res = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                cont++;
            } else if (c == '>' && cont > 0) {
                cont--;
                res++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int res = diamantes(str);

            System.out.println(res);
        }

        sc.close();
    }
}