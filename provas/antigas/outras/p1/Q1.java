class CelulaLista {
    CelulaPilha topo;
    CelulaLista prox;
}

class CelulaPilha {
    int elemento;
    CelulaPilha prox;
}

class Lista {
    CelulaLista inicio, fim;

    CelulaLista percorrer() {
        CelulaLista resp = inicio;
        int maior = 0;
        
        if (inicio == fim) return null;

        for (CelulaLista i = inicio; i != null; i = i.prox) {
            int j = tamanho(i);
            if (j > maior) {
                resp = i;
                maior = j;
            }
        }

        return resp;
    }

    int tamanho(CelulaLista cel) {
        int size = 0;
        
        for (CelulaPilha i = cel.topo; i != null; i = i.prox) size++;

        return size;
    }
}
