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

        arvore.caminhar();

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

    void caminhar() {
        caminhar(raiz);
    }

    void caminhar(No i) {
        if (i != null) {
            caminhar(i.esq);
            i.carro.imprimir();
            caminhar(i.dir);
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
        System.out.println(placa + " " + modelo + " " + tipo + " " + chassi);
    }
}