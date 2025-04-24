class Q3 {
    public static void main(String[] args) {
        ListaDupla l1 = new ListaDupla();
        ListaDupla l2 = new ListaDupla();


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
        Celula c3 = new CelulaDupla();

        

        return c3;
    }
}

class ListaDupla {
    int elemento;
    CelulaDupla primeiro, ultimo;
} 