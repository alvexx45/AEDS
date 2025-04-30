class Celula {
    int elemento;
    Celula prox;

    Celula() { this(0); }

    Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Lista {
    Celula inicio, fim;

    void inverter() {
        Celula a = null, b = null;
        Celula i = inicio;
        fim = inicio;

        while (i != null) {
            a = i.prox;
            i.prox = b;
            b = i;
            i = a;
        }
        inicio = b;
    }
}