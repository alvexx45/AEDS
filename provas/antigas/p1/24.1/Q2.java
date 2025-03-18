class Q2 {
    public static void main(String[] args) {
        Exercicio ex = new Exercicio();
        
        String palavra1 = "radar";
        System.out.println(ex.isPalindromo(palavra1));  // Esperado: true
        
        String palavra2 = "hello";
        System.out.println(ex.isPalindromo(palavra2));  // Esperado: false
        
        String palavra3 = "racecar";
        System.out.println(ex.isPalindromo(palavra3));  // Esperado: true
        
        String palavra4 = "java";
        System.out.println(ex.isPalindromo(palavra4));  // Esperado: false
    }
}

class CriarLista {
    char[] array;
    int cont;

    CriarLista(int size) {
        array = new char[size];
        cont = 0;
    }

    void inserirInicio(char x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        for (int i = cont; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        cont++;
    }

    void inserirFim(char x) {
        if (cont >= array.length) {
            System.err.println();
            return;
        }

        array[cont] = x;
        cont++;
    }

    void inserir(char x, int pos) {
        if (cont >= array.length || (pos < 0 || pos > cont)) {
            System.err.println();
            return;
        }

        for (int i = cont; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        cont++;
    }

    int removerInicio() {
        if (cont == 0) {
            System.err.println();
            return cont;
        }
        
        char resp = array[0];
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

        char resp = array[pos];
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
}

class Exercicio {
    boolean isPalindromo(String s) {
        CriarLista lista = new CriarLista(s.length());
        
        boolean res = true;

        for (int i = 0; i < s.length(); i++) {
            lista.inserirFim(s.charAt(i));
        }

        int inicio = 0;
        int fim = lista.cont - 1;

        while (inicio < fim) {
            if (lista.array[inicio] != lista.array[fim]) {
                res = false;
                inicio = fim;
            }

            inicio++;
            fim--;
        }

        return res;
    }
}