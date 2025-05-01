class CelulaDupla {
    int elemento;
    CelulaDupla ant, prox;

    public CelulaDupla() { this(0); }

    public CelulaDupla(int x) {
        this.elemento = x;
        this.ant = this.prox = null;
    }

    CelulaDupla intercalarReverso(CelulaDupla c1, CelulaDupla c2) {
        ListaDupla l3 = new ListaDupla();
        
        CelulaDupla u1, u2;

        for (u1 = c1; u1 != null; u1 = u1.prox);
        for (u2 = c2; u2 != null; u2 = u2.prox);

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
}