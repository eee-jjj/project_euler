package level6;

import java.math.BigInteger;
import java.util.ArrayList;

import util.PEUtil;

public class P134 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = PEUtil.generatePrimes(1000005);
		BigInteger sum = BigInteger.ZERO;
		for(int i=2;i<primes.size()-1 && primes.get(i)<1000000;i++){
			int p1 = primes.get(i);
			int p2 = primes.get(i+1);
			int len = (int)Math.log10(p1)+1;
			int a10 = (int)Math.pow(10, len);
			int mo = p2-p1;
			
			int x = 0;
			int cnt = 0;
			while(x % p2 != mo){
				x += a10;
				x %= p2;
				cnt++;
			}
			BigInteger res = BigInteger.valueOf(cnt).multiply(BigInteger.valueOf(a10)).add(BigInteger.valueOf(p1));
			//System.out.println(p1 + ", " + p2 + ": "+res);
			if(i%100==0)
				System.out.println(i +"/" +primes.size());
			sum = sum.add(res);
		}
		System.out.println(sum);
	}

}
