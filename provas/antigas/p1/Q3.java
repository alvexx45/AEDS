class Q3 {
    public static void main(String[] args) {
        FilaPrioridade fila = new FilaPrioridade(6);

        fila.inserir(new Paciente("João", 5));
        fila.inserir(new Paciente("Maria", 3));
        fila.inserir(new Paciente("Pedro", 8));
        fila.inserir(new Paciente("Ana", 1));
        fila.inserir(new Paciente("Lucas", 6));
        fila.mostrar();

        fila.remover();
        fila.remover();
        fila.mostrar();
    }
}

class Paciente {
    public String nome;
    public int prioridade;

    public Paciente(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return nome + " (Prioridade: " + prioridade + ")";
    }
}

class FilaPrioridade {
    private Paciente[] itens;
    private int n;

    public FilaPrioridade(int tam) {
        itens = new Paciente[tam];
        n = 0;
    }

    public void inserir(Paciente p) {
        if (n >= itens.length) {
            System.err.println();
            return;
        }

        int pos;

        for (pos = n - 1; pos >= 0 && itens[pos].prioridade < p.prioridade; pos--) {
            itens[pos + 1] = itens[pos];
        }
        itens[pos + 1] = p;

        n++;
    }

    public Paciente remover() {
        if (n == 0) {
            System.err.println("Lista vazia");
            return null;
        }

        Paciente rm = itens[0];

        for (int i = 0; i < n - 1; i++) {
            itens[i] = itens[i + 1];
        }

        n--;
        return rm;
    }

    public void mostrar() {
        if (n == 0) {
            System.out.println("Fila vazia");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(itens[i] + " | ");
        }
        System.out.println();
    }
}