package level8;


public class P197 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        long cap = 10000;
        double u0 = -1;
        double un = u0;
        double c = 30.403243784;
        for(long i=1;i<=cap;i++){
            double unp1 = Math.floor(Math.pow(2, c-un*un))*1e-9;
            System.out.println(i + ": " + unp1);
            System.out.println("sum: " + (un+unp1));
            un = unp1;
        }
    }
    
}
