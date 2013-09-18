package level5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class P124 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 100000;
		boolean[] primes = new boolean[len+1];
		Arrays.fill(primes, true);
		HashSet<Integer>[] factors = new HashSet[primes.length+1];
		for(int i=1;i<primes.length;i++)
			factors[i] = new HashSet<Integer>();
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
		ArrayList<Rad> res = new ArrayList<Rad>();
		for(int i=1;i<=len;i++){
			HashSet<Integer> factor = factors[i];
			int rad = 1;
			for(Integer k : factor)
				rad *= k;
			Rad r = new Rad(i,rad);
			res.add(r);
		}
		Collections.sort(res);
		System.out.println(res.get(10000-1));
	}

}
class Rad implements Comparable<Rad>{
	int n;
	int rad;
	public Rad(int nn, int radd){
		n=nn;
		rad=radd;
	}
	@Override
	public int compareTo(Rad o){
		if(rad != o.rad)
			return rad-o.rad;
		else
			return n-o.n;
	}
	@Override
	public String toString(){
		return "("+n+","+rad+")";
	}
}
