class Lista {
    public static void main(String[] args) {
        
    }
}

class CriarLista {
    Celula primeiro, ultimo;

    CriarLista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    // void inserir(int x) {}

    void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if (primeiro == ultimo) {
            ultimo = tmp;
        }

        tmp = null;
    }

    void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    // int remover() {}

    int removerInicio() {
        if (primeiro == ultimo) return 0;

        Celula tmp = primeiro.prox;
        primeiro.prox = primeiro.prox.prox;
        int elemento = tmp.elemento;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    int removerFim() {
        if (ultimo == primeiro) return 0;

        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox);
        int elemento = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;

        return elemento;
    }

    void mostrar() {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }

    void selection() {
        for (Celula i = primeiro; i.prox != null; i = i.prox) {
            Celula menor = i;
            for (Celula j = i.prox; j != null; j = j.prox) {
                if (j.elemento < menor.elemento) menor = j;
            }

            int tmp = i.elemento;
            i.elemento = menor.elemento;
            menor.elemento = tmp;
        }
    }
}