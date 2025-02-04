import java.util.Scanner;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> pomedex = new HashSet<>();

        int qtd = 151;

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String pmk = sc.nextLine();
            pomedex.add(pmk);
        }

        int res = qtd - pomedex.size();

        System.out.println("Falta(m) " + res + " pomekon(s).");

        sc.close();
    }
}