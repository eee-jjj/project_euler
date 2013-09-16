package level5;

import java.util.Arrays;

public class P115 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 200;
		int minLen = 50;
		
		long[][] dp = new long[len+1][len+1];
		for(int i=0;i<dp.length;i++){
			dp[0][i] = 1;
		}
		for(int i=0;i<dp.length;i++){
			Arrays.fill(dp[i], 1);
		}
		for(int j=minLen;j<dp.length;j++){
			for(int i=1;i<dp.length;i++){				
				if(i>=j+1){
					dp[i][j] = dp[i-1][j];
				}
				for(int l=minLen;l<=j;l++){
					if(i>=l+1)
						dp[i][j] += dp[i-l-1][j];
				}
				if(i==j)
					dp[i][j] = dp[i][j-1] + 1;
				if(i<j)
					dp[i][j] = dp[i][i];
			}
			
		}
		for(int i=0;i<len+1;i++)
			System.out.println(Arrays.toString(dp[i]));
		for(int i=0;i<len+1;i++){
			if(dp[i][i]>1000000){
				System.out.println(i);
				break;
			}
		}
	}
}
