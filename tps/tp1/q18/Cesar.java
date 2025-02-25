import java.util.Scanner;

class Cesar {

	// método público que recebe string e passa index e chave ao privado
	public static String cifrar(String txt) {
		return cifrar(txt, 0, 3);
	}
	
	// método privado responsável pela cifra da string
	private static String cifrar(String txt, int i, int chave) {
		if (i == txt.length()) return "";
		
		char currentChar = txt.charAt(i);
		char cifrado;

		// garantir que o caracter desconhecido mantenha igual
		if (currentChar == '\uFFFD') {
			cifrado = currentChar;
		} else {
			cifrado = (char) (currentChar + chave);
		}
		
		// chamada recursiva
		return cifrado + cifrar(txt, i + 1, chave);
	}

	// método responsável para encerrar o programa quando chamado
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
				// chamada do método público
				String txtCifrado = cifrar(txt);
				System.out.println(txtCifrado);
			}
		}

		sc.close();
	}
}
