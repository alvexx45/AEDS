class CelulaMat {
    CelulaMat inf, sup, esq, dir;
    CelulaLista inicio, fim;
}

class CelulaLista {
    int elemento;
    CelulaLista prox;
}

class Matriz {
    CelulaMat inicio;

    void percorrer() {
        CelulaMat lin = inicio, col = inicio;
 
        while (lin != null) {
            while (col != null) {
                remover(col);
                col = col.dir;
            }
            lin = lin.inf;
            col = lin;
        }
    }

    void remover(CelulaMat i) {
        CelulaLista cabeca = new CelulaLista();

        cabeca.prox = i.inicio;
        CelulaLista j = cabeca;

        while (j.prox != null) {
            if (j.prox.elemento % 2 != 0) {
                j.prox = j.prox.prox;
            } else {
                j = j.prox;
            }
        }
        i.inicio = cabeca.prox;
    }
}