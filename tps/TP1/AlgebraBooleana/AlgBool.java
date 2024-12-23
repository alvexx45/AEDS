import java.util.Scanner;

public class AlgBool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linhaEntrada = "";

        // lê a entrada e processa enquanto a entrada não for 0
        do {
            linhaEntrada = sc.nextLine();
            if (!saoIguais(linhaEntrada, "0")) {
                if (avaliarExpressao(linhaEntrada)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        } while (!saoIguais(linhaEntrada, "0"));

        sc.close();
    }

    // prepara a expressão para avaliação
    public static String prepararExpressao(String entrada) {
        String expressao = "";
        int n = 0;

        n = entrada.charAt(0) - 48;

        expressao = removerEspacos(entrada);
        expressao = substituirOcorrencias("and", 'a', expressao);
        expressao = substituirOcorrencias("or", 'o', expressao);
        expressao = substituirOcorrencias("not", 'n', expressao);

        // substitui as variáveis a, b, c por seus valores
        for (int i = 0; i < n; i++) {
            char c = (char) ('A' + i);
            char novoValor = expressao.charAt(i + 1);
            expressao = substituirOcorrencias(c, novoValor, expressao);
        }

        // remove a quantidade de bits da expressão
        expressao = extrairSubtring(expressao, n + 1, expressao.length());

        return expressao;
    }

    // resolve uma expressão booleana simples
    public static String avaliarSimples(String entrada) {
        int comprimento = entrada.length();
        char operador = entrada.charAt(0);
        boolean flag = true;
        switch (operador) {
            case 'a':
                flag = true;
                for (int i = 2; i < comprimento && flag; i++) {
                    if (entrada.charAt(i) == '0') {
                        flag = false;
                        return "0";
                    }
                }
                return "1";
            case 'o':
                flag = false;
                for (int i = 2; i < comprimento && !flag; i++) {
                    if (entrada.charAt(i) == '1') {
                        flag = true;
                        return "1";
                    }
                }
                return "0";
            case 'n':
                return entrada.charAt(2) == '0' ? "1" : "0";
            default:
                return "";
        }
    }

    // resolver a equação
    public static boolean avaliarExpressao(String entrada) {
        String expressao = prepararExpressao(entrada);
        boolean resultado;
        while (expressao.contains("(")) {
            int inicio = expressao.lastIndexOf('(');
            int fim = expressao.indexOf(')', inicio);

            String subExpressao = extrairSubtring(expressao, inicio - 1, fim + 1);
            String resultadoSub = avaliarSimples(subExpressao);
            expressao = extrairSubtring(expressao, 0, inicio - 1) +
                    resultadoSub +
                    extrairSubtring(expressao, fim + 1, expressao.length());
        }
        resultado = saoIguais(expressao, "1");
        return resultado;
    }

    // verifica se duas strings são iguais
    public static boolean saoIguais(String str1, String str2) {
        boolean resultado = true;
        if (str1.length() != str2.length()) {
            resultado = false;
        } else {
            for (int i = 0; i < str1.length() && resultado; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    resultado = false;
                }
            }
        }
        return resultado;
    }

    // extrai uma substring de uma string
    public static String extrairSubtring(String s, int inicio, int fim) {
        String resultado = "";
        for (int i = inicio; i < fim && i < s.length(); i++) {
            resultado += s.charAt(i);
        }
        return resultado;
    }

    // remove espaços em branco de uma string
    public static String removerEspacos(String entrada) {
        String resultado = "";
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) != ' ') {
                resultado += entrada.charAt(i);
            }
        }
        return resultado;
    }

    // substitui todas as ocorrências de uma string por um caractere
    public static String substituirOcorrencias(Object alvo, char novoChar, String entrada) {
        String resultado = "";
        int comprimento = entrada.length();
        String alvoString = alvo.toString();
        int comprimentoAlvo = alvoString.length();
        for (int i = 0; i < comprimento; i++) {
            boolean ok = i < comprimento - comprimentoAlvo + 1;
            boolean match = saoIguais(extrairSubtring(entrada, i, i + comprimentoAlvo), alvoString);
            if (ok && match) {
                resultado += novoChar;
                i += comprimentoAlvo - 1;
            } else {
                resultado += entrada.charAt(i);
            }
        }
        return resultado;
    }
}
