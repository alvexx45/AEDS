class Q3 {
    public static void main(String[] args) {
        ListaDupla l1 = new ListaDupla();
        ListaDupla l2 = new ListaDupla();

        l1.inserirFim(3);
        l1.inserirFim(7);
        l1.inserirFim(5);

        l2.inserirFim(1);
        l2.inserirFim(9);

        CelulaDupla c3 = new CelulaDupla();
        CelulaDupla res = c3.intercalarReverso(l1.primeiro, l2.primeiro);

        ListaDupla l3 = new ListaDupla();
        l3.primeiro = res;
        l3.mostrar();
    }
}

class CelulaDupla {
    int elemento;
    CelulaDupla ant, prox;

    public CelulaDupla() {this(0); }

    public CelulaDupla(int x) {
        this.elemento = x;
        this.ant = this.prox = null;
    }

    CelulaDupla intercalarReverso(CelulaDupla c1, CelulaDupla c2) {
        ListaDupla l3 = new ListaDupla();

        CelulaDupla u1, u2;
        for (u1 = c1; u1.prox != null; u1 = u1.prox);
        for (u2 = c2; u2.prox != null; u2 = u2.prox);

        while (u1 != c1 || u2 != c2) {
            if (u1 != c1) {
                l3.inserirFim(u1.elemento);
                u1 = u1.ant;
            }
            if (u2 != c2) {
                l3.inserirFim(u2.elemento);
                u2 = u2.ant;
            }
        }

        return l3.primeiro;
    }
}

class ListaDupla {
    int elemento;
    CelulaDupla primeiro, ultimo;

    ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    void inserirFim(int x) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    void mostrar() {
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
} 