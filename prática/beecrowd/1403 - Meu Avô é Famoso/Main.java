import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N == 0 && M == 0) break;

            int[] pontos = new int[10001]; // jogadores de 1 a 10000

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int jogador = sc.nextInt();
                    pontos[jogador]++;
                }
            }

            int melhor = 0, segundo = 0;
            // Encontrar o maior número de aparições
            for (int i = 1; i <= 10000; i++) {
                if (pontos[i] > melhor) {
                    melhor = pontos[i];
                }
            }
            // Encontrar o segundo maior número de aparições
            for (int i = 1; i <= 10000; i++) {
                if (pontos[i] > segundo && pontos[i] < melhor) {
                    segundo = pontos[i];
                }
            }

            // Imprimir todos os jogadores com o número de aparições igual ao segundo lugar
            for (int i = 1; i <= 10000; i++) {
                if (pontos[i] == segundo) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
} 