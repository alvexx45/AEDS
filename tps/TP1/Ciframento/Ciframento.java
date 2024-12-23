import java.util.Scanner;

class Ciframento {

    // método que recebe uma string e retorna a mesma cifrada
    public static String cifrarTexto(String txt) {
        String txtCifrado = "";
        int chave = 3;
        
        // loop que percorre cada caractere do texto e o cifra por meio de deslocamento baseado na tabela ASCII
        for (int j = 0; j < txt.length(); j++) {
			char currentChar = txt.charAt(j);

			if (currentChar == '\uFFFD') {
				// matém o caracter não reconhecido inalterado
				txtCifrado += currentChar;
			} else {
				txtCifrado += (char) (currentChar + chave);
			}
        }
        
        return txtCifrado;
    }

    // método responsável por encerrar o programa quando acionado
    public static boolean stop(String txt) {
        return (txt.length() == 3 && txt.charAt(0) == 'F' && txt.charAt(1) == 'I' && txt.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            String txt = sc.nextLine();
            
            if (stop(txt)) {
                flag = true;
            } else {
                String txtCifrado = cifrarTexto(txt);
                System.out.println(txtCifrado);
            }
        }

        sc.close();
    }
}
