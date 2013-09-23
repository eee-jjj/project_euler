package level6;

import util.PEUtil;
import java.util.*;
import java.util.Map.Entry;

public class P141 {
	static ArrayList<Integer> primes = PEUtil.generatePrimes(1000);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		long cap = 1000000000000L;
//		
//		double xcap = Math.sqrt(cap);
//		
//		for(long x=1;x<xcap;x++){
//			long start = (long)Math.floor(Math.pow(x*x, 1.0/3));
//			for(long y=start;y<x;y++){
//				//long aa = x*x*x*x-y*y*y*4;
//				if(x*x % y ==0)
//					continue;
//				long sq = x*x;
//				if(y*y == sq/y * (sq%y)){
//				//if(PEUtil.isPerfectSquare(aa)){
//					System.out.println(sq+", "+y+","+sq/y+","+sq%y);
//				}
//			}
//		}
		
		long cap = 1000000000000L;
		long rcap = 1000000;
		long sum = 0;
		for(int r=1;r<rcap;r++){
			if(r % 1000 == 0){
				System.out.println("~~~~~~~~~"+r);
			}
			int yunit = findY(r);
			
			double ycap = Math.pow((cap-r)*r, 1.0/3);
			for(long y=r+yunit;y<ycap;y+=yunit){
				double q = y*y*1.0/r;
				if((long)q!=q)
					continue;
				long xx = y*(long)q+r;
				if(PEUtil.isPerfectSquare(xx)){
					System.out.println(xx+", "+y+","+(long)q+","+r);
					sum+=xx;
				}
			}
		}
		System.out.println(sum);
	}
	static int findY(int r){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<primes.size() && primes.get(i)<=Math.sqrt(r);i++){
			while(r % primes.get(i) == 0){
				r /= primes.get(i);
				if(map.containsKey(r)){
					map.put(primes.get(i), map.get(r)+1);
				}
				else
					map.put(primes.get(i), 1);
			}
		}
		int y = 1;
		for(Entry<Integer,Integer> e:map.entrySet()){
			for(int i=0;i<(e.getValue()+1)/2;i++)
				y*=e.getKey();
		}
		return y;
	}
}
