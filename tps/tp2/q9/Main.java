import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Main {
    public static boolean hasFilho(int i, int n) {
        return (i <= (n/2));
    }

    public static int getMaiorFilho(Show[] lista, int i, int tam){
        int filho;
        if (2*i == tam || (lista[2*i].getDirector().compareTo(lista[2*i+1].getDirector()) > 0 || lista[2*i].getDirector().compareTo(lista[2*i+1].getDirector()) == 0 && lista[2*i].getTitle().compareTo(lista[2*i+1].getTitle()) > 0)) {
            filho = 2*i;
        } else {
            filho = 2*i + 1;
        }

        return filho;
    }

    public static void construir(Show[] lista, int n) {
        for (int i = n; i > 1 && (lista[i].getDirector().compareTo(lista[i/2].getDirector()) > 0 || (lista[i].getDirector().compareTo(lista[i/2].getDirector()) == 0 && lista[i].getTitle().compareTo(lista[i/2].getTitle()) > 0)); i /= 2) {
            Show tmp = lista[i];
            lista[i] = lista[i/2];
            lista[i/2] = tmp;
        }
    }

    public static void reconstruir(Show[] lista, int n) {
        int i = 1;

        while (hasFilho(i, n)) {
            int filho = getMaiorFilho(lista, i, n);
            if (lista[i].getDirector().compareTo(lista[filho].getDirector()) < 0 || (lista[i].getDirector().compareTo(lista[filho].getDirector()) == 0 && lista[i].getTitle().compareTo(lista[filho].getTitle()) < 0)) {
                Show tmp = lista[i];
                lista[i] = lista[filho];
                lista[filho] = tmp;
            } else {
                i = n;
            }
        }
    }

    public static void sort(Show[] lista, int n) {
        for (int i = 2; i <= n; i++){
            construir(lista, i);
        }

        int i = n;
        while (i > 1) {
            Show tmp = lista[1];
            lista[1] = lista[i];
            lista[i] = tmp;
            i--;
            reconstruir(lista, i);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String path = "/tmp/disneyplus.csv";
        // String path = "../disneyplus.csv";

        Show[] lista = new Show[1369];
        int i = 0;

        String lerId = sc.nextLine();
        while (!lerId.equals("FIM"))  {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line = br.readLine(); // ignorar primeira linha
                // br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] campos = Show.splitCSV(line);

                    if (campos.length > 0 && campos[0].equals(lerId)) {
                        Show show = new Show();
                        show.ler(line);
                        lista[i++] = show;
                        break;
                    }

                }
            } catch (Exception e) {}
            
            lerId = sc.nextLine();
        }

        sort(lista, i);
        for (int j = 0; j < i; j++) {
            lista[j].imprimir();
        }

        sc.close();
    }
}

class Show {
    private String id;
    private String type;
    private String title;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);

    private String director;
    private String[] cast;
    private String country;
    private LocalDate date;
    private int year;
    private String rating;
    private String duration;
    private String[] listed;

    public String getId() { return id; } 
    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String[] getCast() { return cast; }
    public String getCountry() { return country; }
    public LocalDate getDate() { return date; }
    public int getYear() { return year; }
    public String getRating() { return rating; }
    public String getDuration() { return duration; }
    public String[] getListed() { return listed; }
    
    public void setId(String id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setCast(String[] cast) { this.cast = cast; }
    public void setCountry(String country) { this.country = country; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setYear(int year) { this.year = year; }
    public void setRating(String rating) { this.rating = rating; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setListed(String[] listed) { this.listed = listed; }

    public Show(String id, String type, String title, String director, String[] cast, String country, LocalDate date, int year, String rating, String duration, String[] listed) {
        setId(id);
        setType(type);
        setTitle(title);
        setDirector(director);
        setCast(cast);
        setCountry(country);
        setDate(date);
        setYear(year);
        setRating(rating);
        setDuration(duration);
        setListed(listed);
    }

    public Show() {}


    public static String[] splitCSV(String line) {
        List<String> campos = new ArrayList<>();
        boolean entreAspas = false;
        StringBuilder campo = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                entreAspas = !entreAspas;
            } else if (c == ',' && !entreAspas) {
                campos.add(campo.toString().trim());
                campo.setLength(0); // resetar stringbuilder
            } else {
                campo.append(c);
            }
        }
        campos.add(campo.toString().trim());

        return campos.toArray(new String[0]);
    }

    public void ler(String csv) {
        String[] campos = splitCSV(csv);
    
        if (campos.length >= 11) {
            setId(campos[0].isEmpty() ? "NaN" : campos[0]);
            setType(campos[1].isEmpty() ? "NaN" : campos[1]);
            setTitle(campos[2].isEmpty() ? "NaN" : campos[2]);
            setDirector(campos[3].replace("\"", "").isEmpty() ? "NaN" : campos[3].replace("\"", ""));
    
            String castStr = campos[4].replace("\"", "");
            String[] castArray = castStr.isEmpty() ? new String[]{"NaN"} : castStr.split(", ");
            if (!castStr.isEmpty()) Arrays.sort(castArray);
            setCast(castArray);
    
            setCountry(campos[5].replace("\"", "").isEmpty() ? "NaN" : campos[5].replace("\"", ""));
    
            String dateStr = campos[6].replace("\"", "");
            try {
                setDate(dateStr.isEmpty() ? null : LocalDate.parse(dateStr, DATE_FORMATTER));
            } catch (Exception e) {
                setDate(null);
            }
    
            setYear(campos[7].isEmpty() ? 0 : Integer.parseInt(campos[7]));
            setRating(campos[8].isEmpty() ? "NaN" : campos[8]);
            setDuration(campos[9].isEmpty() ? "NaN" : campos[9]);
    
            String[] listedArray = campos[10].isEmpty() ? new String[]{"NaN"} : campos[10].split(", ");
            setListed(listedArray);
        }
    }

    public void imprimir() {
        System.out.printf("=> %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ##\n",
            id, type, title, director, Arrays.toString(cast), country,
            date == null ? "NaN" : DATE_FORMATTER.format(date),
            year == 0 ? "NaN" : String.valueOf(year),
            rating, duration, Arrays.toString(listed));
    }
}
