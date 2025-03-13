class Fila {
    public static void main(String[] args) {
        CriarFila fila = new CriarFila(6);
        
        fila.enfileirar(5);
        fila.enfileirar(4);
        fila.enfileirar(2);
        fila.enfileirar(13);
        fila.enfileirar(8);
        fila.mostrar();

        fila.desenfileirar();
        fila.desenfileirar();
        fila.desenfileirar();
        fila.mostrar();

        fila.enfileirar(11);
        fila.enfileirar(9);
        fila.mostrar();

        fila.desenfileirar();
        fila.mostrar();

        System.out.println(fila.pesquisar(90));
        System.out.println(fila.retornaPos(1));
    }    
}

class CriarFila {
    int[] array;
    int primeiro, ultimo;

    CriarFila(int size) {
        array = new int[size + 1];
        primeiro = ultimo = 0;
    }

    // CriarFila(int size) {
        // array = new int[size];
        // primeiro = ultimo = 0;
        // capacidade = size;
        // tamanho = 0;
    // }

    void enfileirar(int x) {
        if (((ultimo + 1) % array.length) == primeiro) {
            System.err.println();
            return;
        }

        // if (tamanho == capacidade)

        array[ultimo] = x;
        ultimo = (ultimo + 1) % array.length;
        // tamanho++;
    }

    int desenfileirar() {
        if (primeiro == ultimo) {
            System.err.println();
            return ultimo;
        }

        // if (tamanho == 0);

        primeiro = (primeiro + 1) % array.length;
        // tamanho--;

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

    boolean isVazio() {
        boolean vazio = false;

        if (primeiro == ultimo) vazio = true;

        return vazio;
    }

    boolean pesquisar(int x) {
        if (primeiro == ultimo) {
            return false;
        }

        boolean found = false;

        int i = primeiro;
        while (i != ultimo) {
            i = (i + 1) % array.length;
            if (array[i] == x) {
                found = true;
                i = ultimo;
            }
        }

        return found;
    }

    int retornaPos(int pos) {
        if (primeiro == ultimo) {
            System.err.println("Fila vazia!");
            return 0;
        }

        int tamanho = (ultimo - primeiro + array.length) % array.length;
        
        if (pos < 0 || pos >= tamanho) {
            System.err.println("Posição inválida!");
            return 0;
        }

        int indiceReal = (primeiro + pos) % array.length;
        return array[indiceReal];
    } 

    // implementar sem +1 do construtor
}
