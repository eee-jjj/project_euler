package level6;

import util.PEUtil;
import java.util.*;

public class P146 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = PEUtil.generatePrimes((int)2e8);
		
		long sum = 0;
		for(long i=10;i<150e6;i+=10){
			if(i%3==0 || i%7==0 || i%13==0)
				continue;
			long n2 = i*i;
	
			if(check(primes,n2+1,n2+3,n2+7,n2+9,n2+13,n2+27)){
				if(check2(primes,n2+5,n2+11,n2+15,n2+17,n2+19,n2+21,n2+23,n2+25)){
					sum+=i;
					System.out.println("~~~~"+i);
				}
			}
			
			if(i % 1000000 == 0)
				System.out.println(i);
		}
		System.out.println(sum);
	}
	static boolean check(ArrayList<Integer> primes, long n1, long n3, long n7, long n9, long n13, long n27){
		for(int i=0;i<primes.size() && primes.get(i)<Math.sqrt(n27+100);i++){
			long p = primes.get(i);
			if(n1%p==0 || n3%p==0 || n7%p==0 || n9%p==0 || n13%p==0 || n27%p==0){
				return false;
			}
		}
		return true;
	}
	static boolean check2(ArrayList<Integer> primes, long n5, long n11, long n15, long n17, long n19, long n21, long n23, long n25){
		return !PEUtil.isPrime(n5, primes) && !PEUtil.isPrime(n11, primes) && !PEUtil.isPrime(n15, primes) && !PEUtil.isPrime(n17, primes)
				&& !PEUtil.isPrime(n19, primes) && !PEUtil.isPrime(n21, primes) && !PEUtil.isPrime(n23, primes) && !PEUtil.isPrime(n25, primes);
	}
}
