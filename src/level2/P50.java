package level2;
import java.util.*;
public class P50 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[] primes = new boolean[1000000];
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				for(int j=i+i;j<primes.length;j+=i){
					primes[j]=false;
				}
			}
		}
		
		ArrayList<Integer> ps = new ArrayList<Integer>();
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true)
				ps.add(i);
		}
		
		int max = -1;
		long save = 0;
		for(int i=0;i<ps.size();i++){
			long sum = 0;
			for(int j=i;j<ps.size();j++){
				sum+=ps.get(j);
				if(j-i>max && sum<primes.length && primes[(int) sum]==true){
					max = j-i+1;
					save = sum;
				}
			}
		}
		System.out.println(max +" "+ save);
	}

}
