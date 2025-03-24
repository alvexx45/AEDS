import java.util.Scanner;

class Main {
    public static int padrao(String placa) {
        int res = 0;
        int len = placa.length();

        if (len == 8 && placa.charAt(3) == '-') {
            for (int i = 0; i < 3; i++) {
                if (!Character.isLetter(placa.charAt(i))) {
                    i = 3;
                }
            }

            for (int i = 4; i < 8; i++) {
                if (!Character.isDigit(placa.charAt(i))) { 
                    i = 8;
                }
            }

            res = 1;
        }
        else if (len == 7 && !Character.isLetter(placa.charAt(4))) {
            for (int i = 0; i < 3; i++) {
                if (!Character.isLetter(placa.charAt(i))) {
                    i = 3;
                }
            }

            for (int i = 3; i < 8; i++) {
                if (i != 4) {
                    if (!Character.isDigit(placa.charAt(i))) {
                        i = 7;
                    }
                }
            }

            res = 2;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String placa;
        while (sc.hasNextLine()) {
            placa = sc.nextLine();
            System.out.println(padrao(placa));
        }

        sc.close();
    }
}