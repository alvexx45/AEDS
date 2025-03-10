public class Lista {
    int[] array;
    int cont;

    Lista(int size) {
        array = new int[size];
        cont = 0;
    }

    void inserirInicio(int x) {
        if (cont > size) {
            System.err.println("Lista cheia");
        }

        for (int i = cont; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        cont++;
    }

    void inserirFim(int x) {

    }

    void inserir(int x, int pos) {}

    int removerInicio() {}

    int removerFim() {}

    int remover(int pos) {}

    void mostrar() {}
}