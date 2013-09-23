package level6;

import java.math.BigInteger;
import java.util.*;

import util.PEUtil;

public class P140 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Long> res = new ArrayList<Long>();
		for (long a = 1;; a++) {
			long aa = 5*a*a+2*a+1;
			if (PEUtil.isPerfectSquare(aa)) {
				System.out.println(a+": "+(5*a+1)+", "+Math.sqrt(aa));
				res.add(a);
				if (res.size() == 10){
					break;
				}
			}

		}
		long a9 = 11;
		long a10 = 76;
		long astar = 0;
		for(int i=0;i<15;i++){
			astar = a10*7-a9;
			a9 = a10;
			a10 = astar;
			System.out.println((astar-1)/5);
		}
	}
}
