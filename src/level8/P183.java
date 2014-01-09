package level8;

import java.util.HashMap;

public class P183 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // if we take the derivative of y=(N/x)^x and let y'=0
        // we get x = N/e
        int res = 0;
        int limit = 10000;
        for (int N = 5; N <= limit; N++) {
            int low = (int) Math.floor(N / Math.E);
            int high = (int) Math.ceil(N / Math.E);
            
            double lowValue = Math.pow(N * 1.0 / low, low);
            double highValue = Math.pow(N * 1.0 / high, high);
            
            int v = 0;
            if (lowValue > highValue) {
                v = low;
            } else {
                v = high;
            }
            
            HashMap<Integer, Integer> numF = getFactor(N);
            HashMap<Integer, Integer> denF = getFactor(v);
            
            boolean end = true;
            for(Integer key : denF.keySet()){
                int remain = denF.get(key);
                if(numF.containsKey(key)){
                    remain -= numF.get(key);
                }
                if(remain>0 && key!=2 && key!=5){
                    end = false;
                }
            }
            if(end)
                res-=N;
            else
                res+=N;
        }
        System.out.println(res);
    }
    static HashMap<Integer, Integer> getFactor(int n){
        HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>();
        for(int i=2;i<=(n);i++){
            if(n % i==0){
                factors.put(i, 0);
                while(n % i==0){
                    factors.put(i, factors.get(i)+1);
                    n = n/i;
                }
            }
        }
        return factors;
    }
}
