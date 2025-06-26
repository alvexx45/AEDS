import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        TabelaHash tabela = new TabelaHash();
        String linha = sc.nextLine();

        while (!linha.equals("FIM")) {
            Carro carro = new Carro();
            carro.ler(linha);
            tabela.inserir(carro);
            linha = sc.nextLine();
        }

        String placa = sc.nextLine();

        while (!placa.equals("FIM_BUSCA")) {
            tabela.pesquisar(placa);
            placa = sc.nextLine();
        }

        sc.close();
    }
}

class Celula {
    Carro carro;
    Celula prox;

    Celula(Carro carro) {
        this.carro = carro;
        this.prox = null;
    }
}

class TabelaHash {
    Celula[] tabela;
    final int tam = 101; 

    TabelaHash() {
        this.tabela = new Celula[tam];
        for (int i = 0; i < tam; i++) {
            tabela[i] = null;
        }
    }

    
    private int h(String placa) {
        int hash = 0;
        for (int i = 0; i < placa.length(); i++) {
            hash += (int) placa.charAt(i);
        }
        return hash % tam;
    }

    
    void inserir(Carro carro) {
        int pos = h(carro.placa);

        Celula novo = new Celula(carro);
        novo.prox = tabela[pos];
        tabela[pos] = novo;
    }

    
    void pesquisar(String placa) {
        int pos = h(placa);
        boolean encontrou = false;
        
        Celula atual = tabela[pos];
        while (atual != null) {
            if (atual.carro.placa.equals(placa)) {
                atual.carro.imprimir();
                System.out.println(" (Posicao " + pos + ")");
                encontrou = true;
                break; 
            }
            atual = atual.prox;
        }

        if (!encontrou) {
            System.out.println("PLACA NAO ENCONTRADA");
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