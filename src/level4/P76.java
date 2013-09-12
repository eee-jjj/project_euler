package level4;

/**
 * @author ytao
 *
 */
public class P76 {
	
	public static void main(String[] a){
		int[][] dp = new int[101][101];
		
		for(int i=1;i<101;i++){
			dp[1][i] = 1;
			dp[2][i] = 2;
		}
		for(int i=2;i<101;i++){
			dp[i][1] = 1;
		}
		for(int i=3;i<101;i++){
			for(int j=2;j<101;j++){
				if(j>=i)
					dp[i][j] = dp[i][i-1]+1;
				else
					dp[i][j] = dp[i][j-1] + dp[i-j][j];
			}
		}
		System.out.println(dp[100][100]);
	}
}
