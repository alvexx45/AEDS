class Pilha {
    public static void main(String[] args) {
        CriarPilha pilha = new CriarPilha();
        
        pilha.inserir(9);
        pilha.inserir(5);
        pilha.inserir(12);
        pilha.inserir(3);
        pilha.inserir(2);
        // pilha.mostrar();
        pilha.mostrarRec(pilha.topo);
        System.out.println();
        // pilha.mostrarInv();

        pilha.removerPares();
        pilha.mostrar();
        //pilha.mostrarRecInv(pilha.topo);
        //System.out.println();
        // System.out.println(pilha.soma());
        System.out.println("Soma: " + pilha.somaRec(pilha.topo));

        pilha.remover();
        pilha.remover();
        // pilha.mostrar();
        pilha.mostrarRec(pilha.topo);
        System.out.println();
        System.out.println("Maior: " + pilha.maiorRec(pilha.topo));
    }
}

class CriarPilha {
    Celula topo;

    CriarPilha() { topo = null; }

    void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    int remover() {
        if (topo == null) return 0;

        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    void removerPares() {
        Celula ant = null;

        for (Celula i = topo; i != null; i = i.prox) {
            if (i.elemento % 2 == 0) {
                if (ant == null) {
                    topo = i.prox; // remove do topo
                } else {
                    ant.prox = i.prox;
                }
            } else {
                ant = i;
            }
        }
    }

    void mostrar() {
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }

    void mostrarInv() {
        CriarPilha aux = new CriarPilha();

        for (Celula i = topo; i != null; i = i.prox) {
            aux.inserir(i.elemento);
        }

        while(aux.topo != null) {
            System.out.print(aux.remover() + " ");
        }
        System.out.println();
    }

    void mostrarRec(Celula i) {
        if (i == null) return;
     
        System.out.print(i.elemento + " ");
        mostrarRec(i.prox);
    }

    void mostrarRecInv(Celula i) {
        if (i == null) return;
     
        mostrarRec(i.prox);
        System.out.print(i.elemento + " ");
    }


    int soma() {
        int res = 0;

        for (Celula i = topo; i != null; i = i.prox) {
            res += i.elemento;
        }

        return res;
    }

    int somaRec(Celula i) {
        if (i == null) return 0;

        return i.elemento + somaRec(i.prox);
    }

    int maior() {
        int res = 0;

        for (Celula i = topo; i != null; i = i.prox) {
            if (i.elemento > res) res = i.elemento;
        }

        return res;
    }

    int maiorRec(Celula i) {
        if (i == null) return 0;
        if (i.prox == null) return i.elemento;

        return Math.max(i.elemento, maiorRec(i.prox));
    }
}