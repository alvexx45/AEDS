class Matriz {
    CelulaMat inicio;

    void percorrer() {
        for (CelulaMat lin = inicio; lin != null; lin = lin.inf) {
            for (CelulaMat col = lin; col != null; col = col.dir) {
                remover(col);
            }
        }
    }

    void remover(CelulaMat i) {
        Celula cabeca = i.primeiro;
        Celula j = cabeca;

        while (j.prox != null) {
            if (j.prox.elemento % 2 != 0) {
                j.prox = j.prox.prox;
            } else {
                j = j.prox;
            }
        }

        cabeca = cabeca.prox;
    }
}

class CelulaMat {
    CelulaMat esq, dir, inf, sup;
    Celula primeiro, ultimo;
}

class Celula {
    int elemento;
    Celula prox;
}

