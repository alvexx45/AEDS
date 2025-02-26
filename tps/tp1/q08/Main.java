import java.util.Scanner;

class Main {
    public static int soma(int num) {
        if (num == 0) {
            return 0;
        }

        return (num % 10) + soma(num / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();
        int n = Integer.parseInt(num);
        System.out.println(soma(n));
        
        while (!num.equals("FIM")) {
            num = sc.nextLine();

            if (!num.equals("FIM")) {
                n = Integer.parseInt(num);
                System.out.println(soma(n));    
            }
        }

        sc.close();
    }
}