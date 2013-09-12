package level5;

import java.io.*;
import java.util.*;

public class P105 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("sets.txt"));
		int cnt = 0;
		String line = "";
		while((line=br.readLine())!=null){
			boolean flag = true;
			String[] ss = line.split(",");
			int[] num = new int[ss.length];
			for(int i=0;i<num.length;i++)
				num[i] = Integer.parseInt(ss[i]);
			Arrays.sort(num);
			
			ArrayList<ArrayList<Integer>> sums = new ArrayList<ArrayList<Integer>>();
			out: for(int i=2;i<num.length;i++){
				ArrayList<Integer> s = new ArrayList<Integer>();
				go(i, -1, 0, num, s);
				Collections.sort(s);
				for(Integer x:s){
					if(x==-1){
						flag = false;
						break out;
					}
				}
				sums.add(s);
			}
			for(int i=0;i<sums.size()-1;i++){
				ArrayList<Integer> small = sums.get(i);
				ArrayList<Integer> large = sums.get(i+1);
				if(small.get(small.size()-1)>=large.get(0)){
					flag = false;
					break;
				}
			}
			if(flag){
				for(int i=0;i<num.length;i++)
					cnt+=num[i];
			}
		}
		
		br.close();
		System.out.println(cnt);
	}
	static void go(int n, int minIndex, int sum, int[] num, ArrayList<Integer> sums){
		if(n==0){
			if(sums.contains(sum))
				sums.add(-1);
			else
				sums.add(sum);
			return;
		}
		if(n>num.length-minIndex)
			return;
		for(int i=minIndex+1;i<num.length;i++){
			go(n-1, i, sum+num[i], num, sums);
		}
	}
}
