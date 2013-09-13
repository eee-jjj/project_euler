package util;

import java.util.*;

public class PEUtil {
	public static ArrayList<Integer> generatePrimes (int cap){
		ArrayList<Integer> res = new ArrayList<Integer>();
		boolean[] primes = new boolean[cap+1];
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				res.add(i);
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
				}
			}
		}
		return res;
	}
	public static boolean isPrime(long x, ArrayList<Integer> primes){
		for(Integer prime : primes){
			if(prime>=x)
				return true;
			if(x % prime == 0)
				return false;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
