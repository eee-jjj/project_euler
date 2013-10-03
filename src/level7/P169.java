package level7;

import java.math.BigInteger;
import java.util.*;

public class P169 {
	static HashMap<BigInteger, Long> map = new HashMap<BigInteger, Long>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger target = new BigInteger("10000000000000000000000000");
		long res = go(target);
		System.out.println(res);
	}
	public static long go(BigInteger n){
		if(n.equals(BigInteger.ONE)){
			return 1;
		}
		if(n.equals(BigInteger.valueOf(2))){
			return 2;
		}
		if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
			n = n.divide(BigInteger.valueOf(2));
			BigInteger m = n.subtract(BigInteger.ONE);
			long res1 = 0;
			long res2 = 0;
			if(map.containsKey(m)){
				res1 = map.get(m);
			} else {
				res1 = go(m);
			}
			if(map.containsKey(n)){
				res2 = map.get(n);
			} else {
				res2 = go(n);
			}			
			return res1+res2;
		}
		else{
			n = n.subtract(BigInteger.ONE);
			n = n.divide(BigInteger.valueOf(2));
			if(map.containsKey(n))
				return map.get(n);
			else{
				long res = go(n);
				map.put(n, res);
				return res;
			}
		}
	}
}