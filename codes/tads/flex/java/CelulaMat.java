class CelulaMat {
    int elemento;
    CelulaMat inf, sup, esq, dir;

    CelulaMat() { this(0); }

    CelulaMat(int x) {
        this.elemento = x;
        this.inf = this.sup = this.esq = this.dir = null;
    }
}
