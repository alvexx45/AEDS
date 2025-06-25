import java.util.Scanner;

class Main {
    public static void conectar(int t, Path[] path) {
        for (int i = 0; i < t; i++) {
            for (int j = i + 1; j < t; j++) {
                if (path[i].x.equals(path[j].x) && !path[i].y.equals(path[j].y)) {
                    System.out.println("Not a function.");
                    return;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            for (int j = i + 1; j < t; j++) {
                if (path[i].y.equals(path[j].y) && !path[i].x.equals(path[j].x)) {
                    System.out.println("Not invertible.");
                    return;
                }
            }
        }

        System.out.println("Invertible.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t != 0) {
            sc.nextLine();

            Path[] path = new Path[t];

            for (int i = 0; i < t; i++) {
                String input = sc.nextLine();
                String[] parts = input.split(" -> ");

                if (parts.length != 2) return;

                String x = parts[0].trim();
                String y = parts[1].trim();

                path[i] = new Path(x, y);
            }
            conectar(t, path);

            t = sc.nextInt();
        }

        sc.close();
    }
}

class Path {
    public String x;
    public String y;

    public Path(String x, String y) {
        this.x = x;
        this.y = y;
    }
}