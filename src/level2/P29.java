package level2;
import java.util.*;
public class P29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		int len = primes.length;
		HashSet<ArrayList<Integer>> sigs = new HashSet<ArrayList<Integer>>();
		for(int a = 2;a<=100;a++){
			int[] sig = new int[len];
			int tmp = a;
			for(int i=0;i<len;i++){
				while(tmp % primes[i] ==0){
					sig[i]++;
					tmp = tmp/primes[i];
				}
			}
			
			for(int b=2;b<=100;b++){
				ArrayList<Integer> ssig = new ArrayList<Integer>();
				for(int i=0;i<len;i++){
					ssig.add(sig[i]*b);
				}
				sigs.add(ssig);
			}
		}
		System.out.println(sigs.size());
	}

}
