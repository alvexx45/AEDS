import java.util.Scanner;

class Main {
    public static boolean anagrama(String p1, String p2) {
        boolean res = true;

        p1 = p1.toLowerCase();
        p2 = p2.toLowerCase();

        int cont[] = new int[65536];

        for (int i = 0; i < p1.length(); i++) {
            char c = p1.charAt(i);
            if (c < 256) {
                cont[c]++;
            }
        }
        
        for (int i = 0; i < p2.length(); i++) {
            char c = p2.charAt(i);
            if (c < 256) {
                cont[c]--;
            }
        }

        for (int i = 0; i < 256; i++) {
            if (cont[i] != 0) {
                res = false;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String linha = sc.nextLine();

        while (!linha.equals("FIM")) {
            String[] parts = linha.split(" - ");
            String p1 = parts[0];
            String p2 = parts[1];
    
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