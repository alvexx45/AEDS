import java.util.Scanner;

class Main {
    public static String idioma(String lang) {
        String res = lang;
        
        

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < k; j++) {
                String lang = sc.nextLine();
                idioma(lang);
            }
        }

        sc.close();
    }
}