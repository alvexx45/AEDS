import java.util.Scanner;
import java.io.RandomAccessFile;

public class Arquivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        try {
            RandomAccessFile arq = new RandomAccessFile("numeros.txt", "rw");

            // escreve cada valor real no arquivo
            for (int i = 0; i < n; i++) {
                Double a = sc.nextDouble();
                arq.writeDouble(a);
            }

            arq.close();

            arq = new RandomAccessFile("numeros.txt", "r");
            long pos = arq.length();

            while (pos >= 0) {
                 // move a posição de leitura para trás (8 bytes para um double)
                pos -= 8;
                // posiciona o ponteiro no novo local
                arq.seek(pos); 
                Double num = arq.readDouble(); // Lê o próximo double na posição atual

                // converte o valor double para inteiro
                int numInt = num.intValue();

                if (num - numInt == 0) {
                    System.out.println(numInt);
                } else {
                    System.out.println(num);
                }
            }

            arq.close();

        } catch (Exception e) {}

        sc.close();
    }
}
