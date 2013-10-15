package levelunknown;

import java.util.*;

import util.PEUtil;


public class P203 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int cap = (int)1.2e7;
        ArrayList<Integer> primes = PEUtil.generatePrimes(cap);
        ArrayList<Long> square = new ArrayList<Long>();
        for(int i=0;i<primes.size();i++){
            long p = primes.get(i);
            square.add(p*p);
        }
        HashSet<Long> save = new HashSet<Long>();
        
        long[][] c = new long[60][60];
        c[1][1]=1;
        for(int i=2;i<52;i++){
            for(int j=1;j<=i;j++){
                c[i][j] = c[i-1][j]+c[i-1][j-1];
                boolean f = true;
                if(c[i][j]<4)
                    save.add(c[i][j]);
                for(int k=0;k<square.size() && square.get(k)<=c[i][j];k++){
                    if(c[i][j] % square.get(k) == 0){
                        f = false;
                        break;
                    }
                }
                if(f){
                    save.add(c[i][j]);
                }
            }
        }
        long sum = 0;
        for(Long l:save)
            sum+=l;
        System.out.println(sum);
    }
    
}
