import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        while (n != 0 && k != 0) {
            Stack<Integer> stack = new Stack<>();
            boolean livre = true;

            for (int i = 0; i < n; i++) {
                int cheg = sc.nextInt();
                int saida = sc.nextInt();

                while (!stack.isEmpty() && cheg >= stack.peek()) stack.pop();

                if (!stack.isEmpty() && saida > stack.peek()) livre = false;
                if (stack.size() >= k) livre = false;
                if (livre) stack.push(saida);
            }
            
            System.out.println(livre ? "Sim" : "Nao");
            
            n = sc.nextInt();
            k = sc.nextInt();
        }

        sc.close();
    }
}