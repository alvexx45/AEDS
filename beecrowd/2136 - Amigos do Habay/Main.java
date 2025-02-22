import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static String escolhido(Set<String> amigos) {
        String res = "";
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Set<String> participantes = new TreeSet<>();
        Set<String> amigos = new TreeSet<>();

        
        String input = "";
        while (!input.equals("FIM")) {
            input = sc.nextLine().trim();

            String[] inscricao = input.split(" ");
            String nome = inscricao[0];
            String opcao = inscricao[1];

            if (!nome.isEmpty()) participantes.add(nome);
            if (!opcao.isEmpty() && opcao == "YES") amigos.add(opcao);
        }

        String res = escolhido(amigos);

        for (String nome : participantes) {
            System.out.println(participantes);
        }
        sc.nextLine();
        System.out.println("Amigo do Habay:");
        System.out.println(res);

        sc.close();
    }
}