package level5;

import java.util.*;

public class P121 {
	static HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	static int len = 15;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] p = new double[len];
		for(int i=0;i<len;i++){
			p[i] = 1.0/(i+2);
		}
		for(int i=len/2+1;i<=len;i++){
			c(0, i, new ArrayList<Integer>());
		}
		double res = 0;
		for(ArrayList<Integer> s:set){
			double pp = 1;
			for(int i=0;i<len;i++){
				if(s.contains(Integer.valueOf(i))){
					pp *= p[i];
				}
				else
					pp *= (1-p[i]);
			}
			res += pp;
		}
		System.out.println(1/res);
	}
	static void c(int index, int goal, ArrayList<Integer> cur){
		if(cur.size() == goal){
			set.add(cur);
			return;
		}
		for(int i=index;i<len;i++){
			ArrayList<Integer> curp = new ArrayList<Integer>(cur);
			curp.add(i);
			c(i+1, goal, curp);
		}
	}
}
