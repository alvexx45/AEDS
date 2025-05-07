import java.util.Scanner;

class Main {
    public static int compare(Deuses a, Deuses b) {
        if (a.power != b.power) return b.power - a.power;
        if (a.kills != b.kills) return b.kills - a.kills;
        if (a.mortes != b.mortes) return b.mortes - a.mortes;
        
        return a.nome.compareTo(b.nome);
    }

    public static void quicksort(Deuses[] d, int esq, int dir) {
        int i = esq, j = dir;
        Deuses pivo = d[(esq+dir)/2];

        while (i <= j) {
            while (compare(d[i], pivo) < 0) i++;
            while (compare(d[j], pivo) > 0) j--;

            if (i <= j) {
                Deuses tmp = d[i];
                d[i] = d[j];
                d[j] = tmp;
                i++; j--;
            }
        }

        if (esq < j) quicksort(d, esq, j);
        if (i < dir) quicksort(d, i, dir);
    }

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