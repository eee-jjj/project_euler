package level5;

import java.math.BigInteger;
import java.util.*;

public class P119 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long cap = 10000000000000L;
		
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		
		for(long i=2;i<Math.sqrt(cap);i++){
			BigInteger p = BigInteger.valueOf(i);
			while(p.compareTo(BigInteger.valueOf(cap))<0){
				p = p.multiply(BigInteger.valueOf(i));
				int sum = 0;
				char[] c = String.valueOf(p).toCharArray();
				for(int j=0;j<c.length;j++){
					sum += c[j]-'0';
				}
				if(sum==i){
					list.add(p);
					System.out.println(list);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		System.out.println(list);
	}

}
