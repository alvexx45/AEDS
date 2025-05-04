class Matriz {
    CelulaMatriz inicio;
    int linhas, colunas;
    
    CelulaDupla diagUnificada() {
        if (linhas != colunas || inicio == null) return null; 
        
        CelulaDupla cabecaLD = new CelulaDupla();
        CelulaDupla ultimoLD = cabecaLD;
    
        CelulaMatriz i = inicio;
        while (i != null) {
            for (Celula j = i.inicio.prox; j != null; j = j.prox) {
                CelulaDupla tmp = new CelulaDupla();

                tmp.elemento = j.elemento;
                tmp.ant = ultimoLD;
                ultimoLD.prox = tmp;
                ultimoLD = tmp;
            }

            i = i.dir;
            if (i != null) {
                i = i.inf;
            }
        }
    
        return cabecaLD;
    }
}

class CelulaMatriz {
    CelulaMatriz esq, dir, inf, sup;
    Celula inicio, fim;
}

class Celula {
    int elemento;
    Celula prox;
}

class CelulaDupla {
    int elemento;
    CelulaDupla prox, ant;
}