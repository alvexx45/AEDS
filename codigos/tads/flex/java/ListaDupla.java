class ListaDupla {
    public static void main(String[] args) {
        CriarListaDupla lista = new CriarListaDupla();

        lista.inserirFim(15);
        lista.inserirFim(20);
        lista.inserirFim(10);
        lista.inserirFim(25);
        lista.inserirFim(5);
        lista.mostrar();
        
        lista.selection();
        // lista.quicksort(lista.primeiro.prox, lista.ultimo);
        lista.mostrar();

        lista.removerFim();
        lista.removerFim();
        lista.removerInicio();
        lista.mostrar();
    }
}

class CriarListaDupla {
    int elemento;
    CelulaDupla primeiro, ultimo;

    CriarListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    void inserirInicio(int x) {
        CelulaDupla tmp = new CelulaDupla(x);
        
        // ajuste dos ponteiros
        tmp.ant = primeiro; // anterior é a cabeça
        tmp.prox = primeiro.prox; // prox é o antigo prim elemento
        primeiro.prox = tmp; // prox da cabeça é o novo primeiro

        if (primeiro == ultimo) { // lista vazia
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp; // anterior do antigo prim elemento aponta para o novo
        }
        tmp = null;
    }

    void inserirFim(int x) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    int removerInicio() {
        if (primeiro == ultimo) return 0;

        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;

        return resp;
    }

    int removerFim() {
        if (primeiro == ultimo) return 0;
        
        int resp = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;

        return resp;
    }

    void mostrar() {
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }

    void quicksort(CelulaDupla esq, CelulaDupla dir) {
        if (esq != null && dir != null && esq != dir && esq.ant != dir) {
            CelulaDupla pivo = particionar(esq, dir);
            quicksort(esq, pivo.ant);
            quicksort(pivo.prox, dir);
        }
    }

    CelulaDupla particionar(CelulaDupla esq, CelulaDupla dir) {
        int pivo = dir.elemento;
        CelulaDupla i = esq.ant;

        for (CelulaDupla j = esq; j != dir; j = j.prox) {
            if (j.elemento <= pivo) {
                if (i == null) {
                    i = esq;
                } else {
                    i = i.prox;
                }
                swap(i, j);
            }
        }
        if (i == null) {
            i = esq;
        } else {
            i = i.prox;
        }
        swap(i, dir);
        
        return i;
    }

    void swap(CelulaDupla a, CelulaDupla b) {
        int tmp = a.elemento;
        a.elemento = b.elemento;
        b.elemento = tmp;
    }

    void selection() {
        for (CelulaDupla i = primeiro; i.prox != null; i = i.prox) {
            CelulaDupla menor = i;
            for (CelulaDupla j = i.prox; j != null; j = j.prox) {
                if (j.elemento < menor.elemento) menor = j;
            }

            swap(i, menor);
        }
    }
}