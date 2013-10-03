package level8;

import java.util.Arrays;
import java.util.HashMap;

import util.PEUtil;

public class P179 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int cap = 10000000+1;
//		HashMap<Integer,Integer>[] factors = PEUtil.factorize(cap);
//		int[] nf = new int[cap+1];
//		
//		for(int i=2;i<factors.length;i++){
//			HashMap<Integer, Integer> factor = factors[i];
//			int p = 1;
//			for(Integer v:factor.values()){
//				p *= (v+1);
//			}
//			nf[i] = p;
//		}
//		
//		int cnt = 0;
//		for(int i=2;i<nf.length-1;i++){
//			if(nf[i]==nf[i+1])
//				cnt++;
//		}
//		System.out.println(Arrays.toString(nf));
//		System.out.println(cnt);
		int cap = 10000000+1;
		int[] nf = new int[cap+1];
		boolean[] primes = new boolean[cap+1];
		Arrays.fill(nf,1);
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				nf[i]=2;
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
					int jj = j;
					int times = 0;
					while(jj%i==0){
						jj /= i;
						times++;
					}
					nf[j] *= (times+1);
				}
			}
		}
		
		int cnt = 0;
		for(int i=2;i<nf.length-1;i++){
			if(nf[i]==nf[i+1])
				cnt++;
		}
		//System.out.println(Arrays.toString(nf));
		System.out.println(cnt);
	}

}
