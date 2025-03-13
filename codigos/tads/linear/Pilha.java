class Pilha {
    public static void main(String[] args) {
        CriarPilha pilha = new CriarPilha(6);

        pilha.empilhar(5);
        pilha.empilhar(4);
        pilha.empilhar(2);
        pilha.empilhar(13);
        pilha.empilhar(8);
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

    void empilhar(int x) {
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

        return array[--cont];
    }

    void mostrar() {
        for (int i = 0; i < cont; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
