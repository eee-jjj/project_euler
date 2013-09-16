package level5;

import java.util.Arrays;

public class P117 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 50;
		long dp[] = new long[len+1];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 8;
		
		for(int i=5;i<dp.length;i++){
			dp[i] = dp[i-1] + dp[i-2]*1 + dp[i-3]*1 + dp[i-4]*1;
		}
		
		System.out.println(Arrays.toString(dp));
	}

}
