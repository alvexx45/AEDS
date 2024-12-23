import java.util.Scanner;

class Is {
    public static boolean isVogal(String s) {
        boolean result = true;
        
        for (int i = 0; i < s.length() && result; i++) {
            // converte o caractere lido para minúscula
            char currentChar = Character.toLowerCase(s.charAt(i));
            // verifica se não é vogal
            if (currentChar == '\uFFFD' || !(currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u')) {
                result = false;
            }
        }

        return result;
    }

    public static boolean isConsoante(String s) {
        boolean result = true;

        for (int i = 0; i < s.length() && result; i++) {
            // converte o caractere lido para minúscula
            char currentChar = Character.toLowerCase(s.charAt(i));
            // verifica se não é consoante
            if (currentChar == '\uFFFD' || !(currentChar >= 'a' && currentChar <= 'z') || currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                result = false;
            }
        }

        return result;
    }

    public static boolean isInteiro(String s) {
        boolean result = true;

        if (s.length() == 0) {
            result = false;
        } else {
            for (int i = 0; i < s.length() && result; i++) {
                char currentChar = s.charAt(i);
                // verifica se é um dígito
                if (currentChar == '\uFFFD' || !Character.isDigit(currentChar)) {
                    result = false;
                }
            }
        }

        return result;
    }

    public static boolean isReal(String s) {
        boolean result = true;
        boolean hasDecimalSeparator = false;

        if (s.length() == 0) {
            result = false;
        } else {
            for (int i = 0; i < s.length() && result; i++) {
                char currentChar = s.charAt(i);
                if (currentChar == '\uFFFD') {
                    result = false;
                // verifica se tem separador decimal
                } else if (currentChar == '.' || currentChar == ',') {
                    if (hasDecimalSeparator) {
                        result = false;
                    } else {
                        hasDecimalSeparator = true;
                    }
                } else if (!Character.isDigit(currentChar)) {
                    result = false;
                }
            }
        }

        if (!hasDecimalSeparator) {
            result = false;
        }

        return result;
    }

    // método para encerrar o programa
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
                // chamada dos métodos
                boolean vogal = isVogal(frase);
                boolean cons = isConsoante(frase);
                boolean inteiro = isInteiro(frase);
                boolean real = isReal(frase);
    
                // uso do operador ternário para simplificar
                System.out.print(vogal ? "SIM " : "NAO ");
                System.out.print(cons ? "SIM " : "NAO ");
                System.out.print(inteiro ? "SIM " : "NAO ");
                System.out.println(real ? "SIM" : "NAO");
            }
        }
        sc.close();
    }
}
