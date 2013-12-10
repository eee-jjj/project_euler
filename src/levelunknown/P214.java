package levelunknown;

import java.util.ArrayList;
import java.util.Arrays;

public class P214 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int cap = 40000000;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean[] pflag = new boolean[cap + 1];
		int[] phi = new int[cap + 1];

		Arrays.fill(pflag, true);
		for (int i = 2; i < pflag.length; i++) {
			if (pflag[i] == true) {
				phi[i] = i - 1;
				primes.add(i);
			}
			for(int j=0;j<primes.size() && i*primes.get(j)<pflag.length; j++){
				pflag[i*primes.get(j)] = false;
				if( i % primes.get(j) != 0){
					phi[i*primes.get(j)] = phi[i] * (primes.get(j)-1);
				}
				else{
					phi[i*primes.get(j)] = phi[i] * primes.get(j);
					break;
				}
			}
		}		
		//System.out.println(Arrays.toString(phi));
		
		long sum = 0;
		for(int i=2;i<cap;i++){
			if(pflag[i]==true){
				int num = i;
				int chain = 1;
				while(num!=1){
					num = phi[num];
					chain++;
				}
				//System.out.println(i + ":" + chain);
				if(chain==25){
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}

}
