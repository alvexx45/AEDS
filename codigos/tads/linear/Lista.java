class Lista {
    public static void main(String[] args) {
        CriarLista lista = new CriarLista(6);

        lista.inserirFim(13);
        lista.inserirInicio(10);
        lista.inserir(40, 1);
        lista.inserirFim(28);
        lista.inserir(12, 2);
        lista.mostrar();

        System.out.println(lista.pesquisar(6));

        lista.removerFim();
        lista.remover(1);
        lista.mostrar();
        
        lista.removerInicio();
        lista.mostrar();

        lista.inserirFim(10);
        lista.mostrar();

        System.out.println("Soma: " + lista.somar());
        System.out.println("Maior: " + lista.maior());
        lista.elementos();

        lista.removerFim();
        lista.removerFim();
        lista.removerFim();

        lista.inserirOrdenado(12);
        lista.inserirOrdenado(5);
        lista.inserirOrdenado(18);
        lista.inserirOrdenado(9);
        lista.inserirOrdenado(30);
        lista.mostrar();

        System.out.println(lista.binsearchrec(12, 0, lista.cont-1));
    }
}

class CriarLista {
    int[] array;
    int cont;

    CriarLista(int size) {
        array = new int[size];
        cont = 0;
    }

    void inserirInicio(int x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        for (int i = cont; i > 0; i--) {
            array[i] = array[i - 1];
        }
        // auxIns(0);

        array[0] = x;
        cont++;
    }

    void inserirFim(int x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        array[cont] = x;
        cont++;
    }

    void inserir(int x, int pos) {
        if (cont >= array.length || (pos < 0 || pos > cont)) {
            System.err.println();
            return;
        }

        for (int i = cont; i > pos; i--) {
            array[i] = array[i - 1];
        }
        // auxIns(pos);

        array[pos] = x;
        cont++;
    }

    // void auxIns(int lim) {
    //     for (int i = cont; i > lim; i--) {
    //         array[i] = array[i-1];
    //     }
    // }

    void inserirOrdenado(int x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        int pos;

        for (pos = cont - 1; pos >= 0 && array[pos] > x; pos--) {
            array[pos + 1] = array[pos];
        }
        array[pos + 1] = x;

        cont++;
    }

    int removerInicio() {
        if (cont == 0) {
            System.err.println();
            return cont;
        }
        
        int resp = array[0];
        cont--;

        for (int i = 0; i < cont; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    int removerFim() {
        if (cont == 0) {
            System.err.println();
            return cont;
        }

        return array[--cont];
    }

    int remover(int pos) {
        if (cont == 0 || (pos < 0 || pos >= cont)) {
            System.err.println();
            return cont;
        }

        int resp = array[pos];
        cont--;

        for (int i = pos; i < cont; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    void mostrar() {
        for (int i = 0; i < cont; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    int somar() {
        int res = 0;

        for (int i = 0; i < cont; i++) {
            res += array[i];
        }

        return res;
    }

    int maior() {
        int res = 0;

        for (int i = 0; i < cont; i++) {
            if (array[i] > res) {
                res = array[i];
            }
        }

        return res;
    }

    void elementos() {
        int pares = 0, mcinc = 0;

        for (int i = 0; i < cont; i++) {
            if (array[i] % 2 == 0) pares++;
            if (array[i] % 5 == 0) mcinc++;
        }

        System.out.println("Pares: " + pares + " | Mult. Cinco: " + mcinc);
    }

    boolean pesquisar(int x) {
        boolean res = false;
        
        for (int i = 0; i < cont; i++) {
            if (array[i] == x) {
                res = true;
                i = cont;
            }
        }

        return res;
    }

    void inverter() {}

    void inverterRec() {}

    boolean isOrdenada() { 
        boolean res = false;
    
        return res;
    }

    boolean binsearchrec(int x, int esq, int dir) {
        boolean res = false;
        
        if (esq > dir) return res;
    
        int meio = (esq + dir) / 2;
        
        if (array[meio] == x) {
            res = true;
            return res;
        } else if (array[meio] < x) {
            return binsearchrec(x, meio + 1, dir);
        } else {
            return binsearchrec(x, esq, meio - 1);
        }
    }
}