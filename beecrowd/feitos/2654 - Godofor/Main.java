import java.util.Scanner;

class Main {
    public static void sort(Deuses d[], int n) {
        for (int i = 0; i < n-1; i++) {
            int maior = i;
    
            for (int j = i+1; j < n; j++) {
                if (d[j].power > d[maior].power) {
                    maior = j;
                } else if (d[j].power == d[maior].power) {
                    if (d[j].kills > d[maior].kills) {
                        maior = j;
                    }
                } else if (d[j].kills == d[maior].kills) {
                    if (d[j].mortes > d[maior].mortes) {
                        maior = j;
                    }
                } else if (d[j].kills == d[maior].kills) {
                    if (d[j].nome.compareTo(d[maior].nome) < 0) {
                        maior = j;
                    }
                }
            }

            Deuses tmp = d[i];
            d[i] = d[maior];
            d[maior] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        sc.nextLine();
    
        // List<Deuses> d = new ArrayList<>();
    
        Deuses d[] = new Deuses[n];
        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            int power = sc.nextInt();
            int kills = sc.nextInt();
            int mortes = sc.nextInt();
    
            d[i] = new Deuses(nome, power, kills, mortes);
        }
        sort(d, n);
    
        System.out.println(d[0].nome);
    
        sc.close();

        // Collections.sort(d, (d1, d2) -> {
        // if (d1.power != d2.power) {
        // return Integer.compare(d2.power, d1.power);
        // }
        //
        // if (d1.kills != d2.kills) {
        // return Integer.compare(d2.kills, d1.kills);
        // }
        //
        // if (d1.mortes != d2.mortes) {
        // return Integer.compare(d2.mortes, d1.mortes);
        // }
        //
        // return d1.nome.compareTo(d2.nome);
        // });
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