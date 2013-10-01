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
			if(prime>Math.sqrt(x))
				return true;
			if(x % prime == 0)
				return false;
		}
		return true;
	}
	public static boolean isPerfectSquare(long n){
		if(n<0)
			return false;
		long test = (long)(Math.sqrt(n)+0.5);
		return test*test == n;
	}
	public static HashMap<Integer,Integer>[] factorize(int cap){
		HashMap<Integer,Integer>[] map = new HashMap[cap+1];
		for(int i=0;i<map.length;i++)
			map[i] = new HashMap<Integer, Integer>();
		boolean[] primes = new boolean[cap+1];
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				map[i].put(i, 1);
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
					map[j].put(i, 1);
				}
				int freq = 2;
				for(int j=i*i;j<primes.length && j<primes.length;j*=i){
					for(int k=j;k<primes.length && k>0;k+=j){
						map[k].put(i, freq);
					}
					freq++;
				}
			}
		}
		return map;
	}
	public static int[] numOfFactors(int cap){
		int[] res = new int[cap+1];
		res[1] = 1;
		HashMap<Integer,Integer>[] map = factorize(cap);
		for(int i=2;i<res.length;i++){
			int p = 1;
			for(int prime:map[i].keySet()){
				p *= map[i].get(prime)+1;
			}
			res[i] = p;
		}
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.deepToString(factorize(10000)));
	}

}
