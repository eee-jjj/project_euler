package level8;

import java.util.Arrays;

public class P187 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cap = 100000000;
		boolean[] primes = new boolean[cap+1];
		Arrays.fill(primes, true);
		int[] count = new int[cap+1];
		int cnt = 0;
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				count[i] = 1;
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
					int c = 0;
					int jj=j;
					while(jj%i==0){
						c++;
						jj/=i;
					}
					count[j]+=c;
				}
			}
		}
		for(int i=2;i<count.length;i++){
			if(count[i]==2){
				//System.out.println(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
