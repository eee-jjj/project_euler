package level7;

public class P160 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        long p = 1;
        long cnt2 = 0;
        long cnt5 = 0;
        for (long i = 1; i <= 100 ; i++) {
            long ii=i;
            if(ii%10==0){
                while(ii%10==0){
                    ii/=10;
                }
            }
            if (ii % 2 == 0) {
                int cnt = 0;
                while (ii % 2 == 0) {
                    cnt++;
                    ii/=2;
                }
                p*=ii;
                cnt2 += cnt;
            }            
            if (ii % 5 == 0) {
                int cnt = 0;
                while (ii % 5 == 0) {
                    cnt++;
                    ii/=5;
                }
                p*=ii;
                cnt5 += cnt;
            }
            if(i%2!=0 && i%5!=0){
                p*=ii;
            }
            p %= 100000;
            //System.out.println(i + ": " + p);
        }
        for(long i=0;i<cnt2-cnt5;i++){
            p *= 2;
            p %= 100000;
        }
        System.out.println(p);
    }
    
}
