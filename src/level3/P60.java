package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P60 {
	static ArrayList<Integer> p = new ArrayList<Integer>();
	static boolean[] primes;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		primes = new boolean[10000];
		Arrays.fill(primes, true);
		
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				p.add(i);
				for(int j=i+i;j<primes.length;j=j+i){
					primes[j] = false;
				}
			}
		}
		
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		
		for(int i=0;i<p.size();i++){
			map.put(p.get(i), new HashSet<Integer>());
			for(int j=i+1;j<p.size();j++){
				int p1 = p.get(i);
				int p2 = p.get(j);
				String x1 = String.valueOf(p1)+String.valueOf(p2);
				String x2 = String.valueOf(p2)+String.valueOf(p1);
				long y1 = Long.parseLong(x1);
				long y2 = Long.parseLong(x2);
				if(isP(y1) && isP(y2)){
					map.get(p.get(i)).add(p2);
				}					
			}			
		}
		System.out.println("Map built");
		
		for(int i=1;i<p.size();i++){
			HashSet<Integer> s1 = (HashSet<Integer>)map.get(p.get(i)).clone();
			for(int j=i+1;j<p.size();j++){
				if(!s1.contains(p.get(j)))
					continue;
				HashSet<Integer> s2 = (HashSet<Integer>)map.get(p.get(j)).clone();
				s2.retainAll(s1);
				if(s2.size()==0)
					continue;
				for(int k=j+1;k<p.size();k++){
					if(!s2.contains(p.get(k)))
						continue;
					HashSet<Integer> s3 = (HashSet<Integer>)map.get(p.get(k)).clone();
					s3.retainAll(s2);
					if(s3.size()==0)
						continue;
					else{
						//System.out.println(p.get(i)+" "+p.get(j)+" "+p.get(k) + " "+s3);
					}
					for(int l=k+1;l<p.size();l++){
						if (!s3.contains(p.get(l)))
							continue;
						HashSet<Integer> s4 = (HashSet<Integer>)map.get(p.get(l)).clone();
						s4.retainAll(s3);
						if (s4.size() == 0) {
							continue;
						}
						else
							System.out.println(p.get(i) + " " + p.get(j) + " "
								+ p.get(k) + " " + p.get(l) + " " + s4);
					}
				}
			}
		}
		
		
//		int[] n = {3,7,109,673};
//		
//		int x = 673;
//		while(true){
//			if(primes[x]==true){
//				boolean flag = true; 
//				for(int nn:n){
//					String x1 = String.valueOf(x)+String.valueOf(nn);
//					String x2 = String.valueOf(nn)+String.valueOf(x);
//					long y1 = Long.parseLong(x1);
//					long y2 = Long.parseLong(x2);
//					if(isP(y1)==false || isP(y2)==false){
//						flag = false;
//						break;
//					}
//				}
//				if(flag == true){
//					System.out.println(x);
//					System.exit(0);
//				}				
//			}
//			x+=6;
//		}
	}
	
	public static boolean isP(long x){
		if(x<primes.length)
			return primes[(int)x];
		else{
			int k = 2;
			while(k*k<x){
				if(x % k == 0)
					return false;
				k++;
			}
			return true;
		}
	}
}
