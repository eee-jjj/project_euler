package level8;

import java.util.ArrayList;

import util.PEUtil;

public class P196 {
    
    static ArrayList<Integer> primes = PEUtil.generatePrimes(10000000);
    
    public static void main(String[] args) {
        long cap1 = 5678027;
        long cap2 = 7208785;
        long sum = cal(cap1) + cal(cap2);
        System.out.println(sum);
    }
    
    static long cal(long cap) {
        long start = 0;
        for (long i = 1; i < cap; i++) {
            start += i;
        }
        
        long sum = 0;
        
        long end = start + cap;
        start = start + 1;
        System.out.println(start + "," + end);
        
        boolean[] sieve = new boolean[(int) cap];
        
        for (int i = 0; i < primes.size(); ++i) {
            int p = primes.get(i);
            long st = start + (p - start % p);
            for (long cur = st; cur <= end; cur += p) {
                if(cur != p)
                    sieve[(int) (cur - start)] = true;
            }
        }
        
        for (long i = start; i <= end; i += 1) {
            if(i % 100000 == 0){
                System.out.println(i);
            }
            if (sieve[(int)(i-start)]) {
                continue;
            }
            
            long[] nb = nb(i, cap);
            int cnt = 0;
            for (int j = 0; j < nb.length; j++) {
                if (isP(nb[j])) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                sum += i;
            }
            else if (cnt == 1) {
                for (int j = 0; j < nb.length; j++) {
                    if (isP(nb[j])) {
                        long[] nnb;
                        if (j < 3)
                            nnb = nb(nb[j], cap - 1);
                        else
                            nnb = nb(nb[j], cap + 1);
                        int c = 0;
                        for (int k = 0; k < nnb.length; k++) {
                            if (isP(nnb[k])) {
                                c++;
                            }
                        }
                        if (c >= 2) {
                            sum += i;
                        }
                        break;
                    }
                }
            }
        }
        
        System.out.println(sum);
        return sum;
    }
    
    static long[] nb(long i, long line) {
        long[] nb = new long[6];
        nb[0] = i - (line - 1);
        nb[1] = nb[0] - 1;
        nb[2] = nb[0] + 1;
        nb[3] = i + line;
        nb[4] = nb[3] - 1;
        nb[5] = nb[3] + 1;
        return nb;
    }
    
    static boolean isP(long n) {
        int max = (int) Math.sqrt(n);
        for (int i = 0; primes.get(i) <= max && i < primes.size(); i++) {
            if (n % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }
}
