import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static boolean anagrama(String p1, String p2) {
        boolean res = false;

        if (!(p1.length() != p2.length())) {
            char[] arr1 = p1.toCharArray();
            char[] arr2 = p2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if (Arrays.equals(arr1, arr1)) {
                res = true;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String linha = sc.nextLine();

        while (!linha.equals("FIM")) {
            String[] parts = linha.split(" - ");
            String p1 = parts[0].toLowerCase();
            String p2 = parts[1].toLowerCase();
    
            if (anagrama(p1, p2)) {
                System.out.println("SIM");
            } else {
                System.out.println("NÃO");
            }
            
            linha = sc.nextLine();
        }

        sc.close();
    }
}