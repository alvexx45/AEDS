public class CelulaDupla {
    int elemento;
    CelulaDupla ant, prox;

    public CelulaDupla() {this(0); }

    public CelulaDupla(int x) {
        this.elemento = x;
        this.ant = this.prox = null;
    }
}
