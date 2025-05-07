import java.util.Scanner;

class Main {
    public static void quicksort(Deuses[] d, int esq, int dir)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        sc.nextLine();
    
        Deuses d[] = new Deuses[n];
        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            int power = sc.nextInt();
            int kills = sc.nextInt();
            int mortes = sc.nextInt();
    
            d[i] = new Deuses(nome, power, kills, mortes);
        }
        quicksort(d, 0, n-1);
    
        System.out.println(d[0].nome);
    
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