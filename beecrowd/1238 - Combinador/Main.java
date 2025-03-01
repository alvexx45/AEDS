import java.util.Scanner;

class Main {
    public static void combinador(String str1, String str2) {
        String res = "";
        int i = 0, j = 0;

        while (i < str1.length() || j < str2.length()) {
            if (i < str1.length()) {
                res += str1.charAt(i);
                i++;
            }
            if (j < str2.length()) {
                res += str2.charAt(j);
                j++;
            }
        }

        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str1 = sc.next();
            String str2 = sc.next();
            combinador(str1, str2);
        }

        sc.close();
    }
}