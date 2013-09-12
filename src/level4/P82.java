package level4;

import java.util.*;
import java.io.*;

public class P82 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileReader("matrix.txt"));
		int N = 80;
		int[][] m = new int[N][N];
		for(int i=0;i<N;i++){
			String line = sc.nextLine();
			String[] ss = line.split(",");
			for(int j=0;j<N;j++){
				m[i][j]=Integer.parseInt(ss[j]);
			}
		}		
		sc.close();
		
		int[][] dp = new int[N][N];
		
		for(int i=0;i<N;i++){
			dp[i][0] = m[i][0];
		}
		
		for(int j=1;j<N;j++){			
			for(int i=0;i<80;i++){
				int sum = 0;
				int min = Integer.MAX_VALUE;
				for(int k=i;k>=0;k--){
					sum += m[k][j];
					min = Math.min(min, sum+dp[k][j-1]);
				}
				sum = 0;
				for(int k=i;k<N;k++){
					sum += m[k][j];
					min = Math.min(min, sum+dp[k][j-1]);
				}
				
				dp[i][j] = min;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			min = Math.min(min, dp[i][N-1]);
		}
		System.out.println(min);
	}

}
