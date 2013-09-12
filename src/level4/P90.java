package level4;

import java.util.*;

public class P90 {
	static HashSet<HashSet<Integer>> pset = new HashSet<HashSet<Integer>>();
	static String[] _std = {"01","04","09","16","25","36","49","64","81"};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> std = new HashSet<String>(Arrays.asList(_std));
					
		gen(6, 0, new HashSet<Integer>());
		//System.out.println(pset.size() );
		int cnt =  0;
		int special = 0;
		for(HashSet<Integer> set1:pset){
			for(HashSet<Integer> set2:pset){
				HashSet<String> big = new HashSet<String>();
				if(set1.contains(6)||set1.contains(9)){
					set1.add(6);set1.add(9);
				}
				if(set2.contains(6)||set2.contains(9)){
					set2.add(6);set2.add(9);
				}
				for(Integer a:set1){
					for(Integer b:set2){
						String x = String.valueOf(a)+String.valueOf(b);
						String y = String.valueOf(b)+String.valueOf(a);
						big.add(x);
						big.add(y);
					}
				}
				if(big.containsAll(std)){
					System.out.println(set1 +"\t"+ set2);
					cnt++;
					if(set1.equals(set2))
						special++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(special);
	}
	static void gen(int size, int low, HashSet<Integer> cur){
		if(size==0){
			pset.add(cur);
			return;
		}

		for(int i=low;i<10;i++){
			HashSet<Integer> nset = (HashSet<Integer>)cur.clone();
			nset.add(i);
			gen(size-1, i+1, nset);
		}
	}
}
class Set6{
	HashSet<Integer> set;
	public Set6(){
		
	}
}