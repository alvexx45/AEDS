public class Lista {
    int[] array;
    int cont;

    Lista(int size) {
        array = new int[size];
        cont = 0;
    }

    void inserirInicio(int x) {
        if (cont >= array.length) {
            System.err.println("Lista cheia");
        }

        for (int i = cont; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        cont++;
    }

    void inserirFim(int x) {
        if (cont >= array.length) {
            System.err.println("Lista cheia");
        }

        array[cont] = x;
        cont++;
    }

    void inserir(int x, int pos) {
        if (cont >= array.length || (pos > 0 || pos < 0)) {
            System.err.println("Lista cheia ou pos invalida");
        }

        for (int i = cont; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        cont++;
    }

    int removerInicio() {}

    int removerFim() {}

    int remover(int pos) {}

    void mostrar() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}