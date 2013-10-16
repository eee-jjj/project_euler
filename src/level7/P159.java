package level7;

import java.util.*;

import util.PEUtil;



public class P159 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int cap = 1000000;
        ArrayList<Integer> primes = PEUtil.generatePrimes(cap);
        HashSet<Integer> set = new HashSet<Integer>(primes);
        long[] dp = new long[cap+1];
        long sum = 0;
        
        for(int i=2;i<cap;i++){
            if(set.contains(i)){
                dp[i] = root(i);
            }
            else{
                long max = -1;
                for(int j=2;j<=Math.sqrt(i);j++){
                    if(i%j==0){
                        max = Math.max(max, dp[j]+dp[i/j]);
                    }
                }
                max = Math.max(max, root(i));
                dp[i] = max;
            }
            sum += dp[i];
        }
        for(int i=0;i<dp.length;i++){
            System.out.print(i+":");
            System.out.println(dp[i]);
        }
        
        System.out.println(sum);
    }
    static long root(long n){
        if(n % 9 ==0){
            return 9;
        }
        else{
            return n%9;
        }
    }
}
