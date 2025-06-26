import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Arvore arvore = new Arvore();

        String line = sc.nextLine();
        while (!line.equals("FIM")) {
            Carro carro = new Carro();
            carro.ler(line);
            arvore.inserir(carro);

            line = sc.nextLine();
        }

        String placa = sc.nextLine();
        while (!placa.equals("FIM_BUSCA")) {
            arvore.pesquisar(placa);
            placa = sc.nextLine();
        }

        sc.close();
    }
}

class No {
    Carro carro;
    No esq, dir;

    No(Carro carro) {
        this.carro = carro;
        this.esq = this.dir = null;
    }
}

class Arvore {
    No raiz;

    Arvore() {
        this.raiz = null;
    }

    void inserir(Carro x) {
        raiz = inserir(x, raiz);
    }

    No inserir(Carro x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (x.placa.compareTo(i.carro.placa) < 0) {
            i.esq = inserir(x, i.esq);
        } else if (x.placa.compareTo(i.carro.placa) > 0) {
            i.dir = inserir(x, i.dir);
        }

        return i;
    }

    void pesquisar(String x) {
        pesquisar(x, raiz, 0);
    }

    void pesquisar(String x, No i, int nivel) {
        if (i == null) {
            System.out.println("PLACA NAO ENCONTRADA");
        } else if (x.compareTo(i.carro.placa) == 0) {
            i.carro.imprimir();
            System.out.println( " (Nivel " + nivel + ")");
        } else if (x.compareTo(i.carro.placa) < 0) {
            pesquisar(x, i.esq, nivel+1);
        } else {
            pesquisar(x, i.dir, nivel+1);
        }
    }
}

class Carro {
    String placa, modelo, tipo, chassi;
    
    void ler(String linha) {
        String[] partes = linha.split(",");
        placa = partes[0];
        modelo = partes[1];
        tipo = partes[2];
        chassi = partes[3];
    }

    void imprimir() {
        System.out.print(placa + " " + modelo + " " + tipo + " " + chassi);
    }
}