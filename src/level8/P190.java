package level8;

public class P190 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int cap = 15;
        int res = 0;
        for (int m = 2; m <= cap; m++) {
            
            int sum = 0;
            for (int i = 1; i <= m; i++) {
                sum += i;
            }
            double unit = m * 1.0 / sum;
            double p = 1.0;
            for (int i = 1; i <= m; i++) {
                p *= Math.pow((i * unit), i);
            }            
            res += (long)Math.floor(p);
            System.out.println(p);
        }
        System.out.println(res);
    }
    
}
