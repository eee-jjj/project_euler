package level6;

import java.util.*;

public class P127 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cap = 120000;
		boolean[] primes = new boolean[cap+1];
		Arrays.fill(primes, true);
		ArrayList<Integer>[] factors = new ArrayList[cap+1];
		for(int i=0;i<factors.length;i++)
			factors[i]=new ArrayList<Integer>();
		factors[1].add(1);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				factors[i].add(i);
				for(int j=i+i;j<primes.length;j+=i){
					primes[j]=false;
					factors[j].add(i);
				}
			}
		}
		long[] rad = new long[cap+1];
		for(int i=1;i<rad.length;i++){
			int p = 1;
			for(Integer x:factors[i])
				p*=x;
			rad[i] = p;
		}
		long sum = 0;
		for(int a=1;a<cap/2;a++){
			if(a%1000==0)
				System.out.println(a);
			for(int b=a+1;b+a<cap;b++){				
				int c = a+b;
				if(gcd(a,b)==1 && gcd(b,c)==1 && gcd(a,c)==1){
					if(rad[a]*rad[b]*rad[c]<c){
						sum+=c;
						//System.out.println(a+","+b+","+c);
					}
				}
			}
		}
		System.out.println(sum);
	}
	static int gcd(int a,int b){
		return a==0?b:gcd(b%a,a);
	}
}
