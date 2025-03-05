import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        
        List<Deuses> d = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            int power = sc.nextInt();
            int kills = sc.nextInt();
            int mortes = sc.nextInt();
            sc.nextLine();
            
            d.add(new Deuses(nome, power, kills, mortes));
        }

        Collections.sort(d, (d1, d2) -> {
            if (d1.power != d2.power) {
                return Integer.compare(d2.power, d1.power);
            }
            
            if (d1.kills != d2.kills) {
                return Integer.compare(d2.kills, d1.kills);
            }
            
            if (d1.mortes != d2.mortes) {
                return Integer.compare(d2.mortes, d1.mortes);
            }
            
            return d1.nome.compareTo(d2.nome);
        });

        System.out.println(d.get(0).nome);

        sc.close();
    }
}

class Deuses {
    String nome;
    int power, kills, mortes;

    public Deuses(String nome, int power, int kills, int mortes) {
        this.nome = nome;
        this.power = power;
        this.kills = kills;
        this.mortes = mortes;
    }
}