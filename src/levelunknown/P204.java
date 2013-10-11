package levelunknown;

import java.util.ArrayList;

import util.PEUtil;


public class P204 {
    static long cnt = 0;
    static long cap = (long)1e9;
    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> primes = PEUtil.generatePrimes(100);
        System.out.println(primes);
        
        go(1,0,primes);
        System.out.println(cnt);
    }
    
    static void go(long cur, int primeIndex, ArrayList<Integer> primes){
        if(cur>cap)
            return;
        if(primeIndex >= primes.size()){
            if(cur>0 && cur<=cap){
                cnt++;
                //System.out.println(cur);
            }
            return;
        }
        long prime = primes.get(primeIndex);
        for(long i=0;i<Math.log(cap)/Math.log(prime);i++){
            if(primeIndex==0){
                System.out.println(i);
            }
            go(cur*(long)Math.pow(prime, i), primeIndex+1, primes);
        }
    }
}
