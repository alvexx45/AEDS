class Lista {
    public static void main(String[] args) {
        CriarLista lista = new CriarLista(6);

        lista.inserirFim(20);
        lista.inserirInicio(10);
        lista.inserir(40, 1);
        lista.inserirFim(80);
        lista.inserir(50, 2);

        lista.mostrar();

        lista.removerFim();
        lista.remover(1);

        lista.mostrar();
        
        lista.removerInicio();
        
        lista.mostrar();

        lista.inserirFim(18);

        lista.mostrar();

        System.out.println(lista.somar());
    }
}

class CriarLista {
    int[] array;
    int cont;

    CriarLista(int size) {
        array = new int[size];
        cont = 0;
    }

    void inserirInicio(int x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        for (int i = cont; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        cont++;
    }

    void inserirFim(int x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        array[cont] = x;
        cont++;
    }

    void inserir(int x, int pos) {
        if (cont >= array.length || (pos < 0 || pos > cont)) {
            System.err.println();
            return;
        }

        for (int i = cont; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        cont++;
    }

    int removerInicio() {
        if (cont == 0) {
            System.err.println();
            return cont;
        }

        for (int i = 0; i < cont - 1; i++) {
            array[i] = array[i + 1];
        }

        return --cont;
    }

    int removerFim() {
        if (cont == 0) {
            System.err.println();
            return cont;
        }

        return --cont;
    }

    int remover(int pos) {
        if (cont == 0 || (pos < 0 || pos >= cont)) {
            System.err.println();
            return cont;
        }

        for (int i = pos; i < cont - 1; i++) {
            array[i] = array[i + 1];
        }

        return --cont;
    }

    void mostrar() {
        for (int i = 0; i < cont; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    int somar() {
        int res = 0;

        for (int i = 0; i < cont; i++) {
            res += array[i];
        }

        return res;
    }
}