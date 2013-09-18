package level6;

import java.util.*;

import util.PEUtil;

public class P130 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primess = PEUtil.generatePrimes(1100000);
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashSet<Integer> primes = new HashSet<Integer>(primess);
		
		int cap = 20000;
		
		out: for(int i=6;i<=cap;i++){
			//i = 1099997;
			if(i%2==0 || i%5==0)
				continue;
			int d = 9*i;
			
			int n = 1;
			long m = 10;
			while(true){
				m *= 10;
				n++;
				m = m % d;
				if(m==1){
					if((i-1) % n == 0 && !primes.contains(i)){
						System.out.println(i +":\t"+n);
						res.add(i);
					}
					break;
				}
			}
		}
		System.out.println(res.size());
		System.out.println(res);
		long sum = 0;
		for(int i=0;i<25;i++){
			sum += res.get(i);
		}
		System.out.println(sum);
	}

}
