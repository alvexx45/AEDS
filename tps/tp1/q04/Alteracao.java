import java.util.Scanner;
import java.util.Random;

class Alteracao {
	public static Random random = new Random();

	// método responsável por sortear as letras
	public static String sortear(String txt) {
		int size = txt.length();
		char[] txtSorteado = new char[size];

		// sorteio das letras
		char oldChar = (char) ('a' + (Math.abs(random.nextInt()) % 26));
        char newChar = (char) ('a' + (Math.abs(random.nextInt()) % 26));

		// substitui as ocorrências do caracter antigo pelo novo
		for (int i = 0; i < size; i++) {
			if (txt.charAt(i) == oldChar) {
				txtSorteado[i] = newChar;
			} else {
				txtSorteado[i] = txt.charAt(i);
			}
		}

		// criação de uma nova string já que são objetos imutáveis em java
		return new String(txtSorteado);
	}

	// método responsável por encerrar o programa
	public static boolean stop(String txt) {
		return (txt.length() == 3 && txt.charAt(0) == 'F' && txt.charAt(1) == 'I' && txt.charAt(2) == 'M');
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String texto = "";
		boolean flag = false;
	
		random.setSeed(4);

		while (!flag) {
			texto = sc.nextLine();

			if (stop(texto)) {
				flag = true;
			} else {
				// chamada do método
				String txtSorteado = sortear(texto);
				System.out.println(txtSorteado);
			}
		}

		sc.close();

	}
}
