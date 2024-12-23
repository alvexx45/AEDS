import java.util.Scanner;

public class AlgBool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linha = "";

        do {
            linha = sc.nextLine();
            if (!iguais(linha, "0")) {
                if (resolver(linha)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        } while (!iguais(linha, "0"));

        sc.close();
    }

    public static String preparar(String s) {
        String expr = "";
        int n = s.charAt(0) - '0';

        expr = remover(s);
        expr = substituir("and", 'a', expr);
        expr = substituir("or", 'o', expr);
        expr = substituir("not", 'n', expr);

        for (int i = 0; i < n; i++) {
            char c = (char) ('A' + i);
            char valor = expr.charAt(i + 1);
            expr = substituir(c, valor, expr);
        }

        expr = extrair(expr, n + 1, expr.length());

        return expr;
    }

    public static String avaliar(String s) {
        int len = s.length();
        char op = s.charAt(0);
        boolean flag;
        switch (op) {
            case 'a':
                flag = true;
                for (int i = 2; i < len && flag; i++) {
                    if (s.charAt(i) == '0') {
                        return "0";
                    }
                }
                return "1";
            case 'o':
                flag = false;
                for (int i = 2; i < len && !flag; i++) {
                    if (s.charAt(i) == '1') {
                        return "1";
                    }
                }
                return "0";
            case 'n':
                return s.charAt(2) == '0' ? "1" : "0";
            default:
                return "";
        }
    }

    public static boolean resolver(String s) {
        String expr = preparar(s);
        while (expr.contains("(")) {
            int ini = expr.lastIndexOf('(');
            int fim = expr.indexOf(')', ini);

            String subExpr = extrair(expr, ini - 1, fim + 1);
            String res = avaliar(subExpr);
            expr = extrair(expr, 0, ini - 1) + res + extrair(expr, fim + 1, expr.length());
        }
        return iguais(expr, "1");
    }

    public static boolean iguais(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static String extrair(String s, int ini, int fim) {
        String res = "";
        for (int i = ini; i < fim && i < s.length(); i++) {
            res += s.charAt(i);
        }
        return res;
    }

    public static String remover(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                res += s.charAt(i);
            }
        }
        return res;
    }

    public static String substituir(Object alvo, char novoChar, String s) {
        String res = "";
        String alvoStr = alvo.toString();
        int len = s.length();
        int lenAlvo = alvoStr.length();

        for (int i = 0; i < len; i++) {
            boolean ok = i < len - lenAlvo + 1;
            boolean match = iguais(extrair(s, i, i + lenAlvo), alvoStr);
            if (ok && match) {
                res += novoChar;
                i += lenAlvo - 1;
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
