import java.util.Scanner;

class Main {
    public static void verificar(Xmas[] x, Pessoa[] p, int n, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[j].lingua.compareTo(p[i].idioma) == 0) {
                    System.out.println(p[i].nome);
                    System.out.println(x[j].msg);
                    j = n;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Xmas[] x = new Xmas[n];

        for (int i = 0; i < n; i++) {
            String lingua = sc.nextLine();
            String msg = sc.nextLine();
            x[i] = new Xmas(lingua, msg);
        }

        int m = sc.nextInt();
        sc.nextLine();
        Pessoa[] p = new Pessoa[m];

        for (int i = 0; i < m; i++) {
            String nome = sc.nextLine();
            String idioma = sc.nextLine();
            p[i] = new Pessoa(nome, idioma);
        }
        verificar(x, p, n, m);

        sc.close();
    }
}

class Xmas {
    String lingua;
    String msg;

    public Xmas(String lingua, String msg) {
        this.lingua = lingua;
        this.msg = msg;
    }
}

class Pessoa {
    String nome;
    String idioma;

    public Pessoa(String nome, String idioma) {
        this.nome = nome;
        this.idioma = idioma;
    }
}