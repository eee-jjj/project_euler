package level7;

import java.math.BigInteger;


public class P162 {
    
    public static void main(String[] args) {
        // res = all - noA - noB - noC + noA&noB + noB&noC + noA&noC - noA&noB&noC
        BigInteger res = BigInteger.ZERO;
        
        for(int digits = 3;digits<=16;digits++){
            BigInteger all = calc(16, 15, digits);
            BigInteger noA = calc(15, 14, digits);
            BigInteger no1 = calc(15, 14, digits);
            BigInteger no0 = calc(15, 15, digits);
            BigInteger no1noA = calc(14, 13, digits);
            BigInteger no1no0 = calc(14, 14, digits);
            BigInteger noAno0 = calc(14, 14, digits);
            BigInteger no1noAno0 = calc(13, 13, digits);
            
            BigInteger r = all.subtract(no0).subtract(noA).subtract(no1).add(no1no0).add(no1noA).add(noAno0).subtract(no1noAno0);
            System.out.println(r);
            res = res.add(r);
        }
        System.out.println(res);
    }
    public static BigInteger calc(int n1, int n2, int digits){
        BigInteger ret = BigInteger.ONE;
        for(int i=0;i<digits-1;i++){
            ret = ret.multiply(BigInteger.valueOf(n1));
        }
        ret = ret.multiply(BigInteger.valueOf(n2));
        return ret;
    }
    
}
