class Fila {
    public static void main(String[] args) {
        CriarFila fila = new CriarFila();

        fila.inserir(10);
        fila.inserir(12);
        fila.inserir(5);
        fila.inserir(8);
        fila.mostrar();

        fila.remover();
        fila.remover();
        // fila.removerFisicamente();
        // fila.removerFisicamente();
        fila.mostrar();
    }
}

class CriarFila {
    Celula primeiro, ultimo;

    CriarFila() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    int remover() {
        if (primeiro == ultimo) return 0;

        // guarda celula cabeça
        Celula tmp = primeiro;
        // primeiro elemento real vira a celula cabeça
        primeiro = primeiro.prox;
        int elemento = primeiro.elemento;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    int removerFisicamente() {
        if (primeiro == ultimo) return 0;

        // guarda primeiro elemento real
        Celula tmp = primeiro.prox;
        // primeiro elemento real passa a ser o próximo
        primeiro.prox = primeiro.prox.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    void mostrar() {
        for (Celula i = primeiro.prox; i != ultimo.prox; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
}