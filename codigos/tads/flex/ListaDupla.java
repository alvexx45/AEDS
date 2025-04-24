class ListaDupla {
    public static void main(String[] args) {
        CriarListaDupla lista = new CriarListaDupla();

        lista.inserirFim(5);
        lista.inserirFim(10);
        lista.inserirInicio(15);
        lista.inserirFim(20);
        lista.inserirInicio(25);
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
}