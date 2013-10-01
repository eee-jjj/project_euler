package levelunknown;

import java.util.*;

public class P438 {
	static ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
	static ArrayList<int[][]> histCo = new ArrayList<int[][]>();
	static int n = 4;
	static int[][] stdCo = new int[n+1][n+1];
	static int[][] kco = new int[n+1][n];;
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
		stdCo = deepCopy(coeff);
		
		//slope co
		for(int i=1;i<=n+1;i++){
			for(int j=0;j<n;j++){
				kco[i-1][j] = (j+1)*(int)Math.pow(i, j);
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
		System.out.println(sol.size());
		
		int sum = 0;
		for(ArrayList<Integer> s:sol){
			for(Integer i:s)
				sum+=Math.abs(i);
		}
		System.out.println(sum);
	}
	
	public static void go(ArrayList<Integer> solved){
		if(solved.size()==n){
			if(__check(solved)){
				sol.add(solved);
			}
			return;
		}
		int high = Integer.MAX_VALUE;
		int low = Integer.MIN_VALUE;
		int[][] hist = histCo.get(histCo.size()-1-solved.size());
		for(int i=0;i<solved.size()+2;i++){
			int[] eq = hist[hist.length-1-i];
			int val = eq[eq.length-1];
			
			for(int j=0;j<solved.size();j++){
				val += solved.get(j)*eq[eq.length-2-j];
			}
			
			int c = eq[eq.length-2-solved.size()];
			int tmp = (-val)/c;
			
			if(i%2==0){
				low = Math.max(low, tmp);
			}
			else{
				high = Math.min(high, tmp);
			}
		}
		for(int k=low;k<=high;k++){
			ArrayList<Integer> s = new ArrayList<Integer>(solved);
			s.add(k);
			go(s);
		}
	}
	public static boolean check(ArrayList<Integer> s){
		int sum = 0;
		int[] c = {125,25,5,1,625};
		for(int i=0;i<4;i++){
			sum+=s.get(i)*c[i];
		}
		if(sum+625<=0)
			return false;
		else
			return true;
	}
	
	public static boolean __check(ArrayList<Integer> s){
		int len = stdCo[0].length;
		for(int i=0;i<stdCo.length;i++){
			int sum = 0;
			for(int j=0;j<n;j++){
				sum += stdCo[i][len-2-j]*s.get(j);
			}
			sum += stdCo[i][len-1];
			if(checkK(s, 1)==false)
				return false;
			if(sum==0){
				if(i+1==n+1){
					return false;
				}
				if(checkK(s, i+1)==false)
					return false;
			}
		}
		return true;
	}
	
	public static boolean checkK(ArrayList<Integer> s, int ii){
		int sum = 0;
		for(int i=0;i<s.size()-1;i++){
			sum += kco[ii-1][kco[0].length-2-i]*s.get(i);
		}
		sum+=kco[ii-1][kco[0].length-1];
		
		if(ii % 2 == 1){
			if(sum>=0)
				return false;
		}
		else{
			if(sum<=0)
				return false;
		}
		return true;
	}
	
	public static int[][] deepCopy(int[][] co){
		int[][] res = new int[co.length][co[0].length];
		for(int i=0;i<res.length;i++){
			res[i] = Arrays.copyOf(co[i], co[i].length);
		}
		return res;
	}
}
