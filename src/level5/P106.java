package level5;

import java.util.ArrayList;

public class P106 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 12;
		int[] num = new int[N];
		for(int i=0;i<num.length;i++){
			num[i] = i+1;
		}
		int cnt = 0;
		for(int i=2;i<=N/2;i++){
			ArrayList<ArrayList<Integer>> pick1s = new ArrayList<ArrayList<Integer>>();
			pick(i, -1, num, new ArrayList<Integer>(), pick1s);
			for(ArrayList<Integer> pick1 : pick1s){
				int[] nump = new int[num.length-i];
				int j = 0;
				for(int k:num){
					if(!pick1.contains(k))
						nump[j++] = k;
				}
				ArrayList<ArrayList<Integer>> pick2s = new ArrayList<ArrayList<Integer>>();
				pick(i, -1, nump, new ArrayList<Integer>(), pick2s);
				
				for(ArrayList<Integer> pick2 : pick2s){
					boolean lt = false;
					boolean gt = false;
					for(int k=0;k<i;k++){
						if(pick1.get(k)<pick2.get(k))
							lt = true;
						else if(pick1.get(k)>pick2.get(k))
							gt = true;
					}
					if(lt && gt){
						System.out.println("1:\t"+pick1+"\t2:\t"+pick2);
						cnt++;
					}
				}				
			}
		}
		System.out.println(cnt/2);
	}
	static void pick(int n, int minIndex, int[] num, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> pick){
		if(n==0){
			pick.add(cur);
			return;
		}
		if(n>num.length-minIndex)
			return;
		for(int i=minIndex+1;i<num.length;i++){
			ArrayList<Integer> curp = new ArrayList<Integer>(cur);
			curp.add(num[i]);
			pick(n-1, i, num, curp, pick);
		}
	}
}
