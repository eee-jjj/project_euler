package levelunknown;

public class P235 {
    
    public static void main(String[] args) throws Exception {
        double left = 0;
        double right = 1.01;
        for (int i = 0; i < 200; ++i) {
            double mid = (left + right) / 2;
            double v = calc(mid);
            if (v < -6e11) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(left);
    }
    
    static double calc(double v) {
        double sum = 0;
        int k = 900 - 3;
        double r = 1;
        for (int i = 0; i < 5000; ++i, k -= 3, r *= v) {
            sum += k * r;
        }
        return sum;
    }
    
}
