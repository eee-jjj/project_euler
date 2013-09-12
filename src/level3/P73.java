package level3;
import java.util.Arrays;

/**
 * @author ytao
 *
 */
public class P73 {
	public static void main(String[] a){
		boolean[] primes = new boolean[12005];
		int[] coprime = new int[12005];
		for(int i=0;i<coprime.length;i++){
			coprime[i] = i;
		}
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				coprime[i] = i-1;
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
					coprime[j] -= coprime[j]/i;
				}
			}
		}
		int N = 12000;
		long sum = 0;
		for(int i=2;i<=N;i++){
			sum += coprime[i];
		}
		System.out.println(sum);
		sum = (sum-1)/2;
		System.out.println(sum);
		
	}
}
