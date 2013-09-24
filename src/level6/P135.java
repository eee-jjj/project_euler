package level6;

import java.util.Arrays;

import util.PEUtil;

public class P135 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cap = 50000000;
		//int[] numOfFactors = PEUtil.numOfFactors(cap-1);
		int cnt = 0;
		boolean[] possible = new boolean[cap+1];
		Arrays.fill(possible, true);
		for(int n=1;n<cap;n++){
			//if(numOfFactors[n]<=10)
				//continue;
			if(n%100000==0)
				System.out.println(n);
			if(possible[n]==false)
				continue;
			int c = 0;
			for(int x=1;x<=Math.sqrt(n);x++){
				if((n%x==0) && (n/x+x)%4==0){
					int d = (n/x+x)/4;
					if(d<x){
						c++;
						//System.out.println("n: "+n+", d: "+d+", y: "+x);
					}
					if(d<n/x && x!=n/x){
						c++;
						//System.out.println("n: "+n+", d: "+d+", y: "+n/x);
					}
					if(c>1){
						for(int j=4*n;j<possible.length;j+=4*n)
							possible[j] = false;
						break;
					}
				}
			}
			if(c==1){
				//System.out.println(n);
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}

}
