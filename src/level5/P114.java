package level5;

import java.util.Arrays;

public class P114 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 7;
		int maxLen = len;
		
		int[][] dp = new int[len+1][len+1];
		
		for(int i=0;i<dp.length;i++){
			dp[i][0] = 1;
			dp[i][1] = 1;
			dp[i][2] = 1;
		}
		for(int i=1;i<dp.length;i++){
			dp[0][i] = 1;
			dp[1][i] = 1;
			dp[2][i] = 1;
		}
		dp[4][3] = 3;
		for(int i=3;i<dp.length;i++){
			for(int j=3;j<dp.length;j++){
				if(i>=j+1)
					dp[i][j] = dp[i][j-1] + dp[i-j][j];
				else if(i==j)
					dp[i][j] = dp[i][j-1] + 1;
				else
					dp[i][j] = dp[i][j-1];
			}
		}
		for(int i=0;i<len;i++)
			System.out.println(Arrays.toString(dp[i]));
	}
}
