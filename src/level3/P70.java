package level3;
import java.util.Arrays;

/**
 * @author ytao
 *
 */
public class P70 {
	public static void main(String[] args){
		boolean[] primes = new boolean[10000000];
		int[] coprime = new int[10000000];
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
		double max = 2;
		int nnn = -1;
		for(int i=2;i<primes.length;i++){
			String n = String.valueOf(i);
			String phin = String.valueOf(coprime[i]);
			if(isPerm(n,phin)){
				if((((double)i)/coprime[i])<max){
					max = ((double)i)/coprime[i];
					nnn = i;
				}
			}
		}
		System.out.println(nnn);
	}
	public static boolean isPerm(String x,String y){
		char[] xx = x.toCharArray();
		char[] yy = y.toCharArray();
		Arrays.sort(xx);
		Arrays.sort(yy);
		return Arrays.equals(xx, yy);
	}
}
