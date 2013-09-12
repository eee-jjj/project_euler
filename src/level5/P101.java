package level5;

import java.util.*;

public class P101 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long[] seq = new long[12];
		long ssum = 0;
		for(int i=1;i<seq.length;i++){
			long p = 1;
			long sum = 0;
			for(int j=0;j<11;j++){
				sum += p;
				p *= (-1)*i;
			}
			seq[i] = sum;
		}
		
		for(int i=0;i<seq.length;i++){
			System.out.print(seq[i]+",");
		}
		System.out.println();
		System.out.println((long)Math.pow(11, 11));
		for(int i=2;i<=11;i++){
			long[][] co = new long[i][i];
			for(int j=0;j<co.length;j++){
				co[j][0] = 1;
				co[j][1] = j+1;
			}
			for(int j=2;j<co.length;j++){
				for(int k=0;k<co.length;k++){
					co[k][j] = co[k][j-1] * (k+1);
				}
			}
			long[] sol = solve(co, seq);
			long op = 0;
			long p = 1;
			long x = sol.length+1;
			for(int j=0;j<sol.length;j++){
				op += p*sol[j];
				p *= x;
			}
			ssum += op;
			System.out.println(i +":\t"+ op);
			System.out.println(ssum+1);
		}
		System.out.println(ssum+1);
	}
	static long[] solve(long[][] coo, long[] seqq){
		long[][] co = new long[coo.length][coo.length];
		for(int i=0;i<coo.length;i++)
			co[i] = Arrays.copyOf(coo[i], coo[i].length);
		long[] seq = Arrays.copyOf(seqq, seqq.length);
		
		long[] sol = new long[co.length];
		
		for(int i=0;i<co.length-1;i++){
			for(int j=i+1;j<co.length;j++){
				long t = co[j][i]/co[i][i];
				for(int k=0;k<co.length;k++){
					co[j][k] -= t*co[i][k];
				}
				seq[j+1] -= t*seq[i+1];
			}
		}
		for(int i=co.length-1;i>=0;i--){
			long val = seq[i+1];
			for(int j=co.length-1;j>=0;j--){
				val -= sol[j] * co[i][j];
			}
			sol[i] = val / co[i][i];
		}
		return sol;
	}
}
