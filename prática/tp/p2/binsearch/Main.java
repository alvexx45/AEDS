import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Jogadores[] array = new Jogadores[14];
		int k = 0;

		String line = sc.nextLine();
		while (!line.equals("FIM")) {
			Jogadores j = new Jogadores();

			j.ler(line);
			array[k++] = j;

			line = sc.nextLine();
		}
		insertion(array, k);

		line = sc.nextLine();
		while(!line.equals("FIM")) {
			boolean resp = binsearch(array, k, line);
			System.out.println(resp ? "SIM" : "NAO");

			line = sc.nextLine();
		}

		sc.close();
	}

	public static void insertion(Jogadores[] array, int n) {
		for (int i = 1; i < n; i++) {
			Jogadores pivo = array[i];
			int j = i-1;

			while (j >= 0 && array[j].nome.compareTo(pivo.nome) > 0) {
				array[j+1] = array[j--];
			}
			array[j+1] = pivo;
		}
	}

	public static boolean binsearch(Jogadores[] array, int n, String x) {
		boolean resp = false;
		int esq = 0, dir = n-1;

		while (esq <= dir) {
			int meio = (esq+dir)/2;
			int cmp = array[meio].nome.compareTo(x);

			if (cmp == 0) {
				resp = true;
				esq = n;
			} else if (cmp < 0) {
				esq = meio+1;
			} else {
				dir = meio-1;
			}
		}
		
		return resp;
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
