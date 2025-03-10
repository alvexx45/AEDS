class Pilha {
    public static void main(String[] args) {
        
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
}
