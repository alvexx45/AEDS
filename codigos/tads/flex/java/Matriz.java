class Matriz {
    public static void main(String[] args) {
        
    }
}

class CriarMatriz {
    CelulaMat inicio;
    int linhas, colunas;

    void removerColuna() {
        if (colunas == 0) {
            return;
        } else if (colunas == 1) {
            inicio = null;
            colunas--;
        } else {
            CelulaMat i;
            for (i = inicio; i.dir != null; i = i.dir);

            while (i != null) {
                i.esq = i.esq.dir = null;
                i = i.inf;
            }
            colunas--;
        }
    }

    void removerLinha() {
        if (linhas == 0) {
            return;
        } else if (linhas == 1) {
            inicio = null;
            linhas--;
        } else {
            CelulaMat i;
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

        CelulaMat i = inicio;
        while (i != null) {
            System.out.print(i.elemento + " ");
            i = i.dir;
            if (i != null) {
                i = i.inf;
            }
        }
    }

    void getDiagSecundaria() {
        if (linhas != colunas || inicio == null) return;

        CelulaMat i;
        for (i = inicio ; i.dir != null; i = i.dir);

        while (i != null) {
            System.out.print(i.elemento + " ");
            i = i.esq;
            if (i != null) {
                i = i.inf;
            }
        }
    }
}