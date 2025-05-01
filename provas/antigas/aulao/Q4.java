class CelulaDupla {
    int elemento;
    CelulaDupla ant, prox;

    CelulaDupla intercalarReverso(CelulaDupla c1, CelulaDupla c2) {
        CelulaDupla c3 = null;
        
        CelulaDupla u1, u2;

        for (u1 = c1; c1 != null; u1 = u1.prox);
        for (u2 = c2; c2 != null; u2 = u2.prox);

        while (u1 != c1 || u2 != c2) {

        }

        return c3;
    }

    int removerFim() {
        int resp;
    }
}