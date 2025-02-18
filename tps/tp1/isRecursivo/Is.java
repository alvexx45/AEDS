import java.util.Scanner;

class Is {
    public static boolean isVogal(String s, int i) {
        if (i == s.length()) {
            return true;
        } else {
            char currentChar = Character.toLowerCase(s.charAt(i));
            if (currentChar == '\uFFFD' || !(currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u')) {
                return false;
            }
            return isVogal(s, i + 1);
        }
    }

    public static boolean isConsoante(String s, int i) {
        if (i == s.length()) {
            return true;
        } else {
            char currentChar = Character.toLowerCase(s.charAt(i));
            if (currentChar == '\uFFFD' || !(currentChar >= 'a' && currentChar <= 'z') || currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                return false;
            }
            return isConsoante(s, i + 1);
        }
    }

    public static boolean isInteiro(String s, int i) {
        if (i == s.length()) {
            return s.length() > 0; // se for chamado com string vazia
        } else {
            char currentChar = s.charAt(i);
            if (currentChar == '\uFFFD' || !Character.isDigit(currentChar)) {
                return false;
            }
            return isInteiro(s, i + 1);
        }
    }

    public static boolean isReal(String s, int i, boolean hasDecimalSeparator) {
        if (i == s.length()) {
            return hasDecimalSeparator; // deve ter um separador decimal
        } else {
            char currentChar = s.charAt(i);
            if (currentChar == '\uFFFD') {
                return false;
            } else if (currentChar == '.' || currentChar == ',') {
                if (hasDecimalSeparator) {
                    return false;
                } else {
                    return isReal(s, i + 1, true);
                }
            } else if (!Character.isDigit(currentChar)) {
                return false;
            }
            return isReal(s, i + 1, hasDecimalSeparator);
        }
    }

    public static boolean stop(String txt) {
        return (txt.length() == 3 && txt.charAt(0) == 'F' && txt.charAt(1) == 'I' && txt.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            String frase = sc.nextLine();

            if (stop(frase)) {
                flag = false;
            } else {
                // chamada dos métodos recursivos
                boolean vogal = isVogal(frase, 0);
                boolean cons = isConsoante(frase, 0);
                boolean inteiro = isInteiro(frase, 0);
                boolean real = isReal(frase, 0, false);

                // impressão dos resultados
                System.out.print(vogal ? "SIM " : "NAO ");
                System.out.print(cons ? "SIM " : "NAO ");
                System.out.print(inteiro ? "SIM " : "NAO ");
                System.out.println(real ? "SIM" : "NAO");
            }
        }
        sc.close();
    }
}
