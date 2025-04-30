class Q2 {
}


class CelulaMat {
    int elemento;
    CelulaMat inf, sup, esq, dir;
}

class Matriz {
    CelulaMat inicio;
    int linhas, colunas;

    void remover() {
        CelulaMat aux = inicio;

        for (; aux.dir != null; aux = aux.dir);
        
        for (int i = 0; i < linhas; i++) {
            aux.esq.dir = null;
            aux.esq = null;

            if (aux.inf != null) {
                aux.inf.sup = null;
                CelulaMat aux2 = aux.inf;
                aux.inf = null;
                // free em c
                aux = aux2;
            }
        }
        aux = null;
    }
}