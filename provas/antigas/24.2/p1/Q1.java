class Q1 {
    public static void main(String[] args) {
        int x = 0;
        int n = 20;
        int a = 1;
        int b = 2;
        int c = 3;
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;

        for (int i = 15; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                x += a * 2; // 3 * 1 multiplicações
                cont1++;
            }

            for (int k = i; k < n; k++) {
                x += b * 5;
                x += x * 10;
                cont2++; // 2(n-i) multiplicações
            }

            x += c * 4; // 1 multiplicação
            cont3++;
        }

        System.out.println(cont3 + " " + cont1 + " " + cont2);
    }    
}

// Σ i= 15 até n-1 [4 + 2(n-i)]
// θ (n²)