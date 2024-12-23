import java.util.Scanner;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Leitura {
    private static String http(String url) {
        URL site;
        InputStream inputStream;
        BufferedReader bufferedReader;
        String resposta = "";
        String linha;

        try {
            site = new URI(url).toURL();
            inputStream = site.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((linha = bufferedReader.readLine()) != null) {
                resposta += linha + "\n";
            }

            inputStream.close();
        } catch (Exception e) {}

        return resposta;
    }

    private static void contVogais(String site, char[] vogais) {
        int[] qtdVogais = new int[vogais.length];

        for(int j = 0 ; j < vogais.length ; j ++) {
            for(int i = 0 ; i < site.length() ; i++) {
                if(site.charAt(i) == vogais[j]) {
                    qtdVogais[j]++;
                }
            }
            System.out.print(vogais[j] + "(" + qtdVogais[j] + ") ");
        }       
    }

    private static void contCons(String site, char[] consoantes) {
        int qtdConsoantes = 0;

        for(int j = 0 ; j < consoantes.length ; j++) {
            for(int i = 0 ; i < site.length() ; i++) {
                if(site.charAt(i) == consoantes[j]) {
                    qtdConsoantes++;
                }
            }
        }
        System.out.print("consoante(" + qtdConsoantes + ") ");
    }

    private static void contTags(String site, String[] tags) {
        int[] qtdTags = new int[tags.length];

        for(int j = 0 ; j < tags.length ; j++) {
            for(int i = 0 ; i < site.length() ; i++) {
                if(site.charAt(i) == tags[j].charAt(0) && i + tags[j].length() <= site.length()) {
                    int check = tags[j].length();
                    boolean ehIgual = true;

                    for (int k = 0; k < check; k++) {
                        if (tags[j].charAt(k) != site.charAt(i + k)) {
                            ehIgual = false;
                        }
                    }
                    if (ehIgual) {
                        qtdTags[j]++;
                    }
                }
            }
            System.out.print(tags[j] + "(" + qtdTags[j] + ") ");
        }  
    }
    
    private static void elementos (String nome, String url) {
        String site = http(url);

        char[] vogais = { 'a', 'e', 'i', 'o', 'u', '\u00E1', '\u00E9', '\u00ED', '\u00F3', '\u00FA', '\u00E0', '\u00E8', '\u00EC', '\u00F2', '\u00F9', '\u00E3', '\u00F5', '\u00E2', '\u00EA', '\u00EE', '\u00F4', '\u00FB' };
        char[] consoantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
        String[] tags = {"<br>", "<table>"};

        contVogais(site, vogais);
        contCons(site, consoantes);
        contTags(site, tags);

        System.out.println(nome);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = sc.nextLine();
        String url = "";

        while (!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')) {
            url = sc.nextLine();
            elementos(nome, url);

            nome = sc.nextLine();
        }

        sc.close();
    }
}