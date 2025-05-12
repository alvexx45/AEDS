import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pilha pilha = new Pilha();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            int v = 0;
            if (input.equals("PUSH")) {
                v = sc.nextInt();
                pilha.inserir(v);
            } else if (input.equals("POP")) {
                pilha.remover();
            } else if (input.equals("MIN")) {
                System.out.println(pilha.menor());
            }
        }

        sc.close();
    }
}

class Celula {
    int elemento;
    Celula prox;

    Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha {
    Celula topo;

    void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
    }

    int remover() {
        if (topo == null) System.out.println("EMPTY");

        int resp = topo.elemento;
        topo = topo.prox;
        
        return resp;
    }

    int menor() {
        if (topo == null) System.out.println("EMPTY");
        Celula min = topo;

        for (Celula i = topo; i != null; i = i.prox) {
            if (i.elemento < min.elemento) min = i;
        }

        return min.elemento;
    }
}