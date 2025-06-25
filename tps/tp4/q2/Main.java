import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

class Show {
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private Date date_added;
    private int release_year;
    private String rating;
    private String duration;
    private String[] listed_in;

    public Show() {
        this.show_id = "";
        this.type = "";
        this.title = "";
        this.director = "";
        this.cast = new String[0];
        this.country = "";
        this.date_added = null;
        this.release_year = 0;
        this.rating = "";
        this.duration = "";
        this.listed_in = new String[0];
    }

    public Show(String show_id, String type, String title, String director, String[] cast, String country,
            Date date_added, int release_year, String rating, String duration, String[] listed_in) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.listed_in = listed_in;
    }

    public String getShow_id() {
        return show_id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String[] getCast() {
        return cast;
    }

    public String getCountry() {
        return country;
    }

    public Date getDate_added() {
        return date_added;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String getRating() {
        return rating;
    }

    public String getDuration() {
        return duration;
    }

    public String[] getListed_in() {
        return listed_in;
    }

    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setListed_in(String[] listed_in) {
        this.listed_in = listed_in;
    }

    public static void leiaShow(Show[] show) throws IOException, ParseException {
        BufferedReader file = new BufferedReader(
                new InputStreamReader(new FileInputStream("/tmp/disneyplus.csv"), StandardCharsets.UTF_8));
        file.readLine();

        String linha;
        while ((linha = file.readLine()) != null) {
            String[] divisao = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (int i = 0; i < divisao.length; i++) {
                divisao[i] = divisao[i].replaceAll("^\"|\"$", "").trim();
                if (divisao[i].isEmpty() && linha.contains(",,")) {
                    divisao[i] = "";
                }
            }

            int index = Integer.parseInt(divisao[0].substring(1)) - 1;

            String[] cast = divisao[4].split(",\\s*");
            for (int i = 0; i < cast.length; i++) {
                cast[i] = titleHasAspas(cast[i]);
            }
            ordenandoVetor(cast);

            if (divisao[6].isEmpty()) {
                divisao[6] = "March 1, 1900";
            }
            Date date;
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
            String data = divisao[6];
            date = formatter.parse(data);

            int ano = Integer.parseInt(divisao[7]);
            String[] listed = divisao[10].split(",\\s*");
            for (int i = 0; i < listed.length; i++) {
                listed[i] = titleHasAspas(listed[i]);
            }
            ordenandoVetor(cast);

            show[index] = new Show(divisao[0], divisao[1], titleHasAspas(divisao[2]), divisao[3], cast,
                    divisao[5], date, ano, divisao[8], divisao[9], listed);
        }
        file.close();
    }

    public static void ordenandoVetor(String[] ordenar) {
        for (int i = 0; i < ordenar.length - 1; i++) {
            for (int j = i + 1; j < ordenar.length; j++) {
                if (ehMaior(ordenar[i], ordenar[j])) {
                    String tmp = ordenar[i];
                    ordenar[i] = ordenar[j];
                    ordenar[j] = tmp;
                }
            }
        }
    }

    public static String titleHasAspas(String title) {
        StringBuilder sb = new StringBuilder(title.length());
        boolean aspasAnterior = false;

        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if (c != '"') {
                if (aspasAnterior && c != ' ' && sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(c);
                aspasAnterior = false;
            } else {
                aspasAnterior = true;
            }
        }
        return sb.toString();
    }

    public static boolean ehMaior(String menor, String maior) {
        String[] str1 = menor.split(" ");
        String[] str2 = maior.split(" ");
        if (str1[0].compareTo(str2[0]) > 0) {
            return true;
        } else if (str1[0].compareTo(str2[0]) == 0) {
            if (str1.length > 1 && str2.length > 1) {
                return str1[1].compareTo(str2[1]) > 0;
            }
        }
        return false;
    }

    public void imprimir() {
        System.out.print("=> " + show_id + " ## " + title + " ## " + type + " ## ");
        if (director.isEmpty()) {
            System.out.print("NaN" + " ## " + "[");
        } else {
            System.out.print(director + " ## " + "[");
        }

        if (cast.length == 1 && cast[0].isEmpty()) {
            System.out.print("NaN" + "]");
        } else {
            for (int i = 0; i < cast.length - 1; i++) {
                System.out.print(cast[i] + ", ");
            }
            System.out.print(cast[cast.length - 1] + "]");
        }

        if (country.isEmpty()) {
            System.out.print(" ## " + "NaN" + " ## ");
        } else {
            System.out.print(" ## " + country + " ## ");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        String data = formatter.format(date_added);
        System.out.print(data + " ## ");
        System.out.print(release_year + " ## ");
        System.out.print(rating + " ## ");
        System.out.print(duration + " ## " + "[");

        if (listed_in.length == 1 && listed_in[0].isEmpty()) {
            System.out.println("NaN" + "]" + " ##");
        } else {
            for (int i = 0; i < listed_in.length - 1; i++) {
                System.out.print(listed_in[i] + ", ");
            }
            System.out.println(listed_in[listed_in.length - 1] + "]" + " ##");
        }
    }
}

class NoArvore2 {
    String titulo;
    Show show;
    NoArvore2 esq, dir;

    public NoArvore2(Show show) {
        this.titulo = show.getTitle();
        this.show = show;
        this.esq = null;
        this.dir = null;
    }
}

class Arvore2 {
    NoArvore2 raiz;

    public Arvore2() {
        raiz = null;
    }

    public void inserir(Show show) {
        raiz = inserir(show, raiz);
    }

    private NoArvore2 inserir(Show show, NoArvore2 no) {
        if (no == null) {
            return new NoArvore2(show);
        }

        if (show.getTitle().compareTo(no.titulo) < 0) {
            no.esq = inserir(show, no.esq);
        } else if (show.getTitle().compareTo(no.titulo) > 0) {
            no.dir = inserir(show, no.dir);
        }
        return no;
    }

    public boolean pesquisar(String titulo, StringBuilder path) {
        return pesquisar(titulo, raiz, path);
    }

    private boolean pesquisar(String titulo, NoArvore2 no, StringBuilder path) {
        if (no == null) {
            return false;
        }

        if (path.length() > 0) {
            path.append(" ");
        }

        int cmp = titulo.compareTo(no.titulo);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            path.append("ESQ");
            return pesquisar(titulo, no.esq, path);
        } else {
            path.append("DIR");
            return pesquisar(titulo, no.dir, path);
        }
    }
}

class NoArvore1 {
    int chave;
    NoArvore1 esq, dir;
    Arvore2 arvore;

    public NoArvore1(int chave) {
        this.chave = chave;
        this.esq = null;
        this.dir = null;
        this.arvore = new Arvore2();
    }
}

class ArvorePrincipal {
    NoArvore1 raiz;

    public ArvorePrincipal() {
        raiz = null;
    }

    public void inserir(Show show) {
        int chave = show.getRelease_year() % 15;
        raiz = inserir(show, chave, raiz);
    }

    private NoArvore1 inserir(Show show, int chave, NoArvore1 no) {
        if (no == null) {
            NoArvore1 novo = new NoArvore1(chave);
            novo.arvore.inserir(show);
            return novo;
        }

        if (chave < no.chave) {
            no.esq = inserir(show, chave, no.esq);
        } else if (chave > no.chave) {
            no.dir = inserir(show, chave, no.dir);
        } else {
            no.arvore.inserir(show);
        }
        return no;
    }

    public String pesquisar(String titulo) {
        StringBuilder path = new StringBuilder();
        boolean encontrado = pesquisar(titulo, raiz, path, true);
        if (encontrado) {
            return path.toString() + " SIM";
        } else {
            return path.toString() + " NAO";
        }
    }

    private boolean pesquisar(String titulo, NoArvore1 no, StringBuilder path, boolean isRoot) {
        if (no == null) {
            return false;
        }

        if (path.length() > 0) {
            path.append(" ");
        }

        if (isRoot) {
            path.append("raiz");
        }

        StringBuilder pathArv2 = new StringBuilder();
        boolean encontrado = no.arvore.pesquisar(titulo, pathArv2);
        if (encontrado) {
            path.append(pathArv2.toString());
            return true;
        }

        boolean encontradoEsq = false;
        boolean encontradoDir = false;

        if (no.esq != null) {
            path.append(" esq");
            encontradoEsq = pesquisar(titulo, no.esq, path, false);
            if (encontradoEsq) {
                return true;
            }
        }

        if (no.dir != null) {
            path.append(" dir");
            encontradoDir = pesquisar(titulo, no.dir, path, false);
            if (encontradoDir) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    static Show[] show = new Show[1368];

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        Show.leiaShow(show);
        String linha = sc.nextLine();
        ArvorePrincipal arvorePrincipal = new ArvorePrincipal();

        while (!linha.equals("FIM")) {
            int index = Integer.parseInt(linha.substring(1)) - 1;
            arvorePrincipal.inserir(show[index]);
            linha = sc.nextLine();
        }

        linha = sc.nextLine();
        while (!linha.equals("FIM")) {
            String resultado = arvorePrincipal.pesquisar(linha);
            System.out.println(resultado);
            linha = sc.nextLine();
        }
    }
}