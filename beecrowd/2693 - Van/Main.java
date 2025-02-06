import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Van> van = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();
            van.add(new Van(nome, dir, dist));
        }

        Collections.sort(van, (v1, v2) -> {
            if (v1.dist != v2.dist) {
                return Integer.compare(v1.dist, v2.dist);
            }

            return v1.nome.compareTo(v2.nome);
        });

        for (int i = 0; i < n ; i++) {
            System.out.println(van.get(i).nome);
        }

        sc.close();
    }
}

class Van {
    String nome;
    char dir;
    int dist;

    public Van(String nome, char dir, int dist) {
        this.nome = nome;
        this.dir = dir;
        this.dist = dist;
    }
}
