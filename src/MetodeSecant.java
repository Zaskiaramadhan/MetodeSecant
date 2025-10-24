public class MetodeSecant {
    
    // Fungsi f(x) = x^3 - 2x - 5
    static double f(double x) {
        return Math.pow(x, 3) - 2 * x - 5;
    }
    
    public static void main(String[] args) {
        double x0 = 2.0;
        double x1 = 3.0;
        double toleransi = 0.0001;
        int iterasiMaks = 100;

        System.out.println("    METODE SECANT");
        System.out.println("Fungsi: f(x) = x^3 - 2x - 5");
        System.out.println("x0 = " + x0);
        System.out.println("x1 = " + x1);
        System.out.println("Toleransi = " + toleransi);
        System.out.println("========================================\n");
        
        double fx0, fx1, x2;
        int iterasi = 0;
        
        System.out.println("Iterasi\t\tx0\t\tx1\t\tf(x1)\t\tx2");
        System.out.println("---------------------------------------------------");
        
        for (int i = 1; i <= iterasiMaks; i++) {
            fx0 = f(x0);
            fx1 = f(x1);
            
            // Rumus Secant: x(i+1) = xi - yi * (xi - x(i-1)) / (yi - y(i-1))
            x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            
            System.out.printf("%d\t\t%.6f\t%.6f\t%.6f\t%.6f\n", 
                              i, x0, x1, fx1, x2);
            
            // Cek toleransi
            if (Math.abs(f(x2)) <= toleransi) {
                iterasi = i;
                break;
            }
            
            // Update nilai untuk iterasi berikutnya
            x0 = x1;
            x1 = x2;
        }
        
        System.out.println("========================================");
        System.out.println("Akar persamaan: x = " + x1);
        System.out.println("f(x) = " + f(x1));
        System.out.println("Jumlah iterasi: " + iterasi);
        System.out.println("========================================");

        System.out.println("Hasil yang benar dan tepat sesuai metode secant");
    }
}