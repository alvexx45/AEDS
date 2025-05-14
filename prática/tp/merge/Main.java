import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Jogadores[] array = new Jogadores[14];
		int k = 0;

		String line = sc.nextLine();
		while(!line.equals("FIM")) {
			Jogadores j = new Jogadores();
			
			j.ler(line);
			array[k++] = j;

			line = sc.nextLine();
		}
		mergesort(array, 0, k-1);

		for (int i = 0; i < k; i++) {
			array[i].imprimir();
		}

		sc.close();
	}	
	
	public static void mergesort(Jogadores[] array, int esq, int dir) {
		if (esq < dir) {
			int meio = (esq+dir)/2;
			mergesort(array, esq, meio);
			mergesort(array, meio+1, dir);
			intercalar(array, esq, meio, dir);
		}
	}

	public static int compare(String a, String b) {
		return a.compareTo(b);
	}

	private static void intercalar(Jogadores[] array, int esq, int meio, int dir) {
		int n1 = meio-esq+1;
		int n2 = dir-meio;
		int i, j, k;

		Jogadores[] a1 = new Jogadores[n1];
		Jogadores[] a2 = new Jogadores[n2];

		for (i = 0; i < n1; i++) {
			a1[i] = array[esq+i]; 
		}

		for (j = 0; j < n2; j++) {
			a2[j] = array[meio+j+1];
		}

		i = 0; j = 0; k = esq;

		while (i < n1 && j < n2) {
			if ((compare(a1[i].nome, a2[j].nome) <= 0)) {
				array[k++] = a1[i++];
			} else {
				array[k++] = a2[j++];
			}
		}

		while (i < n1) array[k++] = a1[i++];
		while (j < n2) array[k++] = a2[j++];
	}
}

class Date {
	String dia;
	String mes;
	String ano;
}

class Jogadores {
	public String nome;
	public String foto;
	public Date nascimento;
	public int id;
	public int[] times;

	public void imprimir() {
		System.out.print(this.id + " " + this.nome + " " + this.nascimento.dia + "/" + this.nascimento.mes + "/"
				+ this.nascimento.ano + " " + this.foto + " " + "(");
		for (int i = 0; i < times.length - 1; i++) {
			System.out.print(times[i] + ", ");
		}
		System.out.println(times[times.length - 1] + ")");
	}

	public void ler(String input) {
		int i = 0;
		String index = separar(input, i, ',');
		i += index.length() + 1;
		this.nome = separar(input, i, ',');
		i += nome.length() + 1;
		this.foto = separar(input, i, ',');
		i += foto.length() + 1;
		this.nascimento = new Date();
		this.nascimento.dia = separar(input, i, '/');
		i += nascimento.dia.length() + 1;
		this.nascimento.mes = separar(input, i, '/');
		i += nascimento.mes.length() + 1;
		this.nascimento.ano = separar(input, i, ',');
		i += nascimento.ano.length() + 1;
		index = separar(input, i, ',');
		i += index.length() + 1;
		String idString = separar(input, i, ',');
		this.id = Integer.parseInt(idString);
		i += idString.length() + 1;
		int n = contarTimes(input, i);
		if (input.charAt(i) == '"')
			i += 2;
		else
			i++;
		this.times = new int[n];
		for (int j = 0; j < n - 1; j++) {
			String timeString = separar(input, i, ',');
			this.times[j] = Integer.parseInt(timeString);
			i += timeString.length() + 2;
		}
		String timeString = separar(input, i, ']');
		this.times[n - 1] = Integer.parseInt(timeString);
	}

	public String separar(String input, int i, char delimiter) {
		String stringer = "";
		while (input.charAt(i) != delimiter) {
			stringer += input.charAt(i);
			i++;
		}
		return stringer;
	}

	public int contarTimes(String input, int i) {
		int times = 1;
		while (input.charAt(i) != ']') {
			if (input.charAt(i) == ',') {
				times++;
			}
			i++;
		}
		return times;
	}
}
