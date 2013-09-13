package level5;

import java.util.*;

import util.PEUtil;

public class P111 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = PEUtil.generatePrimes(1000000);
		long sum = 0;
		int len = 10;
		for(int i=0;i<=9;i++){
			StringBuilder x = new StringBuilder();
			for(int t=len-1;t>1;t--){
				for(int j=0;j<t;j++)
					x.append(String.valueOf(i));
				
				ArrayList<StringBuilder> save = new ArrayList<StringBuilder>();
				ArrayList<StringBuilder> newlist = new ArrayList<StringBuilder>();
				save.add(x);
				for(int tt=0;tt<len-x.length();tt++){
					for (StringBuilder xx : save) {
						for (int k = 0; k <= xx.length(); k++) {
							for (int d = 0; d < 10; d++) {
								StringBuilder xxx = new StringBuilder(xx);
								xxx.insert(k, d);
								newlist.add(xxx);
							}
						}
					}
					save = newlist;
					newlist = new ArrayList<StringBuilder>();
				}
				HashSet<Long> ps = new HashSet<Long>();
				for(StringBuilder xx : save){
					if(xx.toString().startsWith("0"))
						continue;
					if(PEUtil.isPrime(Long.valueOf(xx.toString()), primes)){
						ps.add(Long.valueOf(xx.toString()));
					}
				}
				if(ps.size()>0){
					System.out.println(i + ":\t" + ps);
					for(long l:ps)
						sum += l;
					break;
				}
				x = new StringBuilder();
			}
		}
		System.out.println(sum);
	}

}
