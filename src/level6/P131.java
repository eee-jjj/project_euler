package level6;

import util.PEUtil;
import java.util.*;

public class P131 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cnt = 0;
		ArrayList<Integer> primes = PEUtil.generatePrimes(1000000);
		for(int i=0;i<primes.size();i++){
			int p = primes.get(i);
			for(long x=1;3*x<p;x++){
				double sqrtxx = Math.sqrt(x*(4*p-3*x));
				if(sqrtxx != (int)sqrtxx)
					continue;
				long up = 3*x*x+x*(int)sqrtxx;
				long down = 2*(p-3*x);
				if(up % down == 0){
					System.out.println(p + ": " +up/down+","+x);
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
