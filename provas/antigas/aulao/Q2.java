class Celula {
    int elemento;
    Celula prox;

    Celula() { this(0); }

    Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Lista {
    Celula inicio, fim;

	void inverter() {
		Celula prev = null, next = null;
		Celula i = inicio;
		fim = inicio;
		
		while (i != null) {
			next = i.prox;
			i.prox = prev;
			prev = i;
			i = next;
		}
		inicio = prev;
	}
}
