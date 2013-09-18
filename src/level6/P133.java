package level6;

import java.util.*;

import util.PEUtil;

public class P133 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primess = PEUtil.generatePrimes(100000);
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		out: for(int j=0;j<primess.size();j++){
			int i = primess.get(j);
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
					//System.out.println(i +":\t"+n);
					while(n % 2==0){
						n /= 2;
					}
					while(n % 5==0){
						n /= 5;
					}
					if(n==1)
						res.add(i);
						
					break;
				}
			}
		}
		System.out.println(res);
		long sum = 0;
		for(Integer p:primess){
			if(res.contains(p))
				continue;
			sum+=p;
		}
		System.out.println(sum);
	}

}
