class Pilha {
    public static void main(String[] args) {
        CriarPilha pilha = new CriarPilha(6);

        pilha.inserir(5);
        pilha.inserir(4);
        pilha.inserir(2);
        pilha.inserir(13);
        pilha.inserir(8);
        pilha.mostrar();

        pilha.remover();
        pilha.remover();
        pilha.remover();
        pilha.mostrar();
    }    
}

class CriarPilha {
    int[] array;
    int cont;

    CriarPilha(int size) {
        array = new int[size];
        cont = 0;
    }

    void inserir(int x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        array[cont] = x;
        cont++;
    }

    int remover() {
        if (cont == 0) {
            System.err.println();
            return cont;
        }

        return --cont;
    }

    void mostrar() {
        for (int i = 0; i < cont; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
