package level5;

import util.PEUtil;
import java.util.*;

public class P123 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = PEUtil.generatePrimes(1000000);
		primes.add(0, 0);
		System.out.println(primes);
		
		for(int i=1;i<primes.size();i+=2){
			long pn = primes.get(i);
			long x = pn*i*2;
			long r = x % (pn*pn);
			if(r>10000000000L){
				System.out.println(i);
				break;
			}
		}
	}

}
