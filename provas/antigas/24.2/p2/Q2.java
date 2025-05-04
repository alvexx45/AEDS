class CelulaMat {
    int elemento;
    CelulaMat inf, sup, esq, dir;
}

class Matriz {
    CelulaMat inicio;
    int linhas, colunas;

    void removerUltimaColuna() {
    	if (colunas == 0) {
    		throw;
    	} else if (colunas == 1) {
    		inicio = null;
    		colunas--;
    	} else {
    		Celula i;
    		for (i = inicio; i.dir != null; i = i.dir);
    		
    		while (i != null) {
    			i.esq = i.esq.dir = null;
    			i = i.inf;
    		}
    		colunas--;
    	}
    }
    
    void removerUltimaLinha() {
    	if (linhas == 0) {
    		throw;
    	} else if (linhas == 1) {
    		inicio = null;
    		linhas--;
    	} else {
    		Celula i;
    		for (i = inicio; i.inf != null; i = i.inf);
    		
    		while (i != null) {
    			i.sup = i.sup.inf = null;
    			i = i.dir;
    		}
    		linhas--;
    	}
    }
    
    void getDiagPrincipal() {
    	if (linhas != colunas || inicio == null) return;
    	
    	Celula i = inicio;
    	
    	while (i != null) {
    		sysout(i.elemento + " ");
    		i = i.dir;
    		if (i != null) {
    			i = i.inf;
    		}
    	}
    }
    
    void getDiagSecundaria() {
    	if (linhas != colunas || inicio == null) return;
    	
    	Celula i;
    	for (i = inicio; i.dir != null; i = i.dir);
    	
    	while (i != null) {
    		sysout(i.elemento + " ");
    		i = i.esq;
    		if (i != null) {
				i = i.inf;
    		}
    	}
    }
    
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
    
    void print() {
    	for (Celula i = inicio; i != null; i = i.inf) {
    		for (Celula j = i; j != null; j = j.dir) {
    			sysout(i.elemento + " ");
    		}
    		println();
    	}
    }
}
