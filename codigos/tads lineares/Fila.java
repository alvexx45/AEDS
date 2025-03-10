class Fila {
    public static void main(String[] args) {
        CriarFila fila = new CriarFila(6);
        
        fila.inserir(5);
        fila.inserir(4);
        fila.inserir(2);
        fila.inserir(13);
        fila.inserir(8);
        fila.mostrar();

        fila.remover();
        fila.remover();
        fila.remover();
        fila.mostrar();

        fila.inserir(11);
        fila.inserir(9);
        fila.mostrar();

        fila.remover();
        fila.mostrar();
    }    
}

class CriarFila {
    int[] array;
    int primeiro, ultimo;

    CriarFila(int size) {
        array = new int[size + 1];
        primeiro = ultimo = 0;
    }

    void inserir(int x) {
        if (((ultimo + 1) % array.length) == primeiro) {
            System.err.println();
            return;
        }
        array[ultimo] = x;
        ultimo = (ultimo + 1) % array.length;
    }

    int remover() {
        if (primeiro == ultimo) {
            System.err.println();
            return ultimo;
        }

        primeiro = (primeiro + 1) % array.length;

        return primeiro;
    }

    void mostrar() {
        int i = primeiro;
        while (i != ultimo) {
            System.out.print(array[i] + " ");
            i = (i + 1) % array.length;
        }
        System.out.println();
    }

    boolean isVazio() {}

    void mostrarRec() {}

    boolean pesquisar(int elementos) {}

    int retornaPos(int pos) {}

    // implementar sem +1 do construtor
}
