import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		ArrayList<Jogadores> list = new ArrayList<>();
		while(!line.equals("FIM")){
			Jogadores j = new Jogadores();

			j.ler(line);
			list.add(j);
			
			line = sc.nextLine();
		}
		insertion(list);


		for (int i = 0; i < ) {
			jogador.imprimir();

		}


		sc.close();
	}

	public static void insertion(ArrayList<Jogadores> list) {
		for (int i = 1; i < list.size(); i++) {
			Jogadores pivo = list.get(i);
			int j = i-1;

			while (j >= 0 && list.get(j).id > pivo.id) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, pivo);
		}
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
