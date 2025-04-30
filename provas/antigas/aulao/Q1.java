class Lista {
    CelulaLista inicio, fim;

    CelulaLista maiorPilha() {
        CelulaLista resp = inicio;
        int maior = 0;

        if (inicio == fim) return null;

        for (CelulaLista i = inicio; i != null; i = i.prox) {
            int j = tamanhoPilha(i);

            if (j > maior) {
                resp = i;
                maior = j;
            }
        }

        return resp;
    }

    int tamanhoPilha(CelulaLista i) {
        int cont = 0;

        for (CelulaPilha j = i.topo; j != null; j = j.prox) cont++;

        return cont;
    }
}

class CelulaLista {
    CelulaPilha topo;
    CelulaLista prox;

}

class CelulaPilha {
    int elemento;
    CelulaPilha prox;
}