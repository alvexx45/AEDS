class Lista {
    public static void main(String[] args) {
        CriarLista lista = new CriarLista(6);

        lista.inserirFim(13);
        lista.inserirInicio(10);
        lista.inserir(40, 1);
        lista.inserirFim(28);
        lista.inserir(12, 2);
        lista.mostrar();

        lista.removerFim();
        lista.remover(1);
        lista.mostrar();
        
        lista.removerInicio();
        lista.mostrar();

        lista.inserirFim(10);
        lista.mostrar();

        System.out.println("Soma: " + lista.somar());
        System.out.println("Maior: " + lista.maior());
        lista.elementos();

        lista.removerFim();
        lista.removerFim();
        lista.removerFim();

        lista.inserirOrdenado(12);
        lista.inserirOrdenado(5);
        lista.inserirOrdenado(18);
        lista.inserirOrdenado(9);
        lista.inserirOrdenado(30);
        lista.mostrar();
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

    void inserirOrdenado(int x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        int pos;

        for (pos = cont - 1; pos >= 0 && array[pos] > x; pos--) {
            array[pos + 1] = array[pos];
        }
        array[pos + 1] = x;

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

    int maior() {
        int res = 0;

        for (int i = 0; i < cont; i++) {
            if (array[i] > res) {
                res = array[i];
            }
        }

        return res;
    }

    void elementos() {
        int pares = 0, mcinc = 0;

        for (int i = 0; i < cont; i++) {
            if (array[i] % 2 == 0) pares++;
            if (array[i] % 5 == 0) mcinc++;
        }

        System.out.println("Pares: " + pares + " | Mult. Cinco: " + mcinc);
    }


}