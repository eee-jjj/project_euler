package level4;

import java.util.*;

public class P87 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		int N = 50000000;
		
		int x = (int)Math.pow(N, 1.0/2);
		int y = (int)Math.pow(N, 1.0/3);
		int z = (int)Math.pow(N, 1.0/4);
		
		boolean[] primes = new boolean[x+50];
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
				}
			}
		}
		ArrayList<Integer> p = new ArrayList<Integer>();
		for(int i=2;i<primes.length;i++){
			if(primes[i])
				p.add(i);
		}
		int len = p.size();
		int cnt = 0;
		HashSet<Long> set = new HashSet<Long>();
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				for(int k=0;k<len;k++){
					long a = p.get(i);
					long b = p.get(j);
					long c = p.get(k);
					long sum = a*a*a*a+b*b*b+c*c;
					if(sum<0 || sum>=N)
						break;
					else{
						cnt++;
						set.add(sum);
					}	
//					if(sum<0){
//						System.out.println("Warning");
//					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(set.size());
	}

}
