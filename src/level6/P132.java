package level6;

import java.util.*;

import util.PEUtil;

public class P132 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primess = PEUtil.generatePrimes(100000000);
		HashSet<Integer> primes = new HashSet<Integer>(primess);
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		out: for(int i=1;;i++){
			
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
					if(primes.contains(i)){
						if(1000000000 % n ==0){
							factors.add(i);
							System.out.println(i +":\t"+n+"++++++++++");
							if(factors.size()==40){
								System.out.println(factors);
								break out;
							}
						}
						else{
							//System.out.println(i +":\t"+n);
						}
					}					
					break;
				}
			}
		}
		long sum = 0;
		for(int i=0;i<factors.size();i++){
			sum += factors.get(i);
		}
		System.out.print(sum);
	}

}
