package levelunknown;

import java.util.*;

public class P438 {
	static ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
	static ArrayList<int[][]> histCo = new ArrayList<int[][]>();
	static int n = 4;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		//generate coefficients
		int[][] coeff = new int[n+1][n+1];
		for(int i=0;i<n+1;i++){
			int base = i+1;
			for(int j=0;j<n+1;j++){
				coeff[i][j] = (int)Math.pow(base, j);
			}
		}
		
		//solve the linear system
		histCo.add(deepCopy(coeff));
		for(int i=0;i<n-1;i++){
			int[][] newCo = deepCopy(coeff);
			for(int j=i+1;j<n+1;j++){
				for(int k=0;k<n+1;k++){
					newCo[j][k] = coeff[j][k]-coeff[j-1][k];
				}
			}
			histCo.add(deepCopy(newCo));
			coeff = newCo;
		}
		
		System.out.println(histCo);
		
		go(new ArrayList<Integer>());
		
		System.out.println(sol);
	}
	
	public static void go(ArrayList<Integer> solved){
		if(solved.size()==n){
			sol.add(solved);
			return;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[][] hist = histCo.get(histCo.size()-1-solved.size());
		for(int i=0;i<solved.size()+2;i++){
			int[] eq = hist[hist.length-1-i];
			int val = eq[eq.length-1];
			
			for(int j=0;j<solved.size();j++){
				val += solved.get(j)*eq[eq.length-1-solved.size()];
			}
			
			int c = eq[eq.length-2-solved.size()];
			int tmp = (-val)/c;
			min = Math.min(tmp, min);
			max = Math.max(tmp, max);
		}
		for(int k=min+1;k<=max-1;k++){
			ArrayList<Integer> s = new ArrayList<Integer>(solved);
			s.add(k);
			go(s);
		}
	}
	
	public static int[][] deepCopy(int[][] co){
		int[][] res = new int[co.length][co[0].length];
		for(int i=0;i<res.length;i++){
			res[i] = Arrays.copyOf(co[i], co[i].length);
		}
		return res;
	}
}
