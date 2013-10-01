package level6;

import java.util.HashSet;

import util.PEUtil;

public class P144 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cap = 120000;
		HashSet<Long> set = new HashSet<Long>();
		for(long p=1;p<=cap;p++){
			for(long q=1;q<=p;q++){
				if(p+q>cap)
					break;
				
				long a2 = p*p+q*q+p*q;
				if(!PEUtil.isPerfectSquare(a2))
					continue;
				
				for(long r=1;r<=q;r++){
					if(p+q+r>cap)
						break;
					
					long b2 = p*p+r*r+p*r;
					if(!PEUtil.isPerfectSquare(b2))
						continue;
					long c2 = q*q+r*r+q*r;
					if(!PEUtil.isPerfectSquare(c2))
						continue;
					
					System.out.println(p+q+r);
					set.add(p+q+r);
				}
			}
		}
		long sum = 0;
		for(Long l:set)
			sum += l;
		System.out.println(sum);
	}

}
