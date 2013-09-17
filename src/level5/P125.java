package level5;

import java.util.*;

public class P125 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ll = 1;
		int cap = 100000000;
		long sum = 0;
		while(true){
			sum+=ll*ll;
			if(sum>cap){
				ll--;
				break;
			}
			ll++;
		}
		HashSet<Integer> res = new HashSet<Integer>();
		for(int len=2;len<=ll;len++){
			int start = 1;
			while (true) {
				long summ = 0;
				for (int i = 0; i < len; i++) {
					summ += (start + i) * (start + i);
				}
				if (summ < cap && isPalin(String.valueOf(summ)))
					res.add((int) summ);
				if(summ>cap)
					break;
				start++;
			}
		}
		long summm = 0;
		for(Integer x:res)
			summm+=x;
		System.out.println(summm);
	}
	static boolean isPalin(String n){
		char[] x = n.toCharArray();
		int p1 = 0;
		int p2 = x.length-1;
		while(p1<p2){
			if(x[p1]!=x[p2])
				return false;
			p1++;
			p2--;
		}
		return true;
	}
}
