package level5;

import java.math.BigInteger;
import java.util.*;

public class P110 {
	static int[] p = {2,3,5,7,11,13,17,19,23,29,31,37,41,43};
	static int[] limit = {5,5,5,5,5,3,1,1,1,1,1,1,1,1,1};
	static ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		go(1, 0, new ArrayList<Integer>());
		BigInteger max = new BigInteger("1000000000000000000");
		ArrayList<Integer> finals = new ArrayList<Integer>();
		for(ArrayList<Integer> s : sol){
			BigInteger n = BigInteger.ONE;
			for(int i=0;i<s.size();i++){
				n = n.multiply(BigInteger.valueOf((long)Math.pow(p[i], s.get(i))));
			}
			if(n.compareTo(max)<0){
				finals = s;
				max = n;
			}
		}
		System.out.println(max +":\t"+ finals);
	}
	static void go(long product, int index, ArrayList<Integer> cur){
		if(index>=p.length){
			if(product > 8000000){
				System.out.println(cur);
				sol.add(cur);
			}
			return;
		}
		for(int i=0;i<=limit[index];i++){
			if(cur.size()>0 && i>cur.get(cur.size()-1))
				break;
			long pp = (2*i+1);
			ArrayList<Integer> curp = new ArrayList<Integer>(cur);
			curp.add(i);
			go(pp*product, index+1, curp);
		}
	}
}
