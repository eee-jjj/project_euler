package level4;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ytao
 *
 */
public class P77 {
	public static void main(String[] a){
		boolean[] primes = new boolean[100000];
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
				}
			}
		}
		
		int[][] dp = new int[101][101];
		
		for(int i=2;i<101;i++){
			dp[2][i] = 1;
		}
		for(int i=2;i<101;i+=2){
			dp[i][2] = 1;
		}
		for(int i=3;i<101;i++){
			for(int j=2;j<101;j++){
				if(j>=i)
					dp[i][j] = dp[i][i-1]+ (primes[i]?1:0);
				else{
					int jj = j;
					if(primes[j]==true){
						dp[i][jj] = dp[i][jj-1] + dp[i-jj][jj];
						if(dp[i][jj]>5000){
							System.out.println(i);
							System.exit(0);
						}
					}
					else{
						dp[i][j] = dp[i][j-1];
					}				
				}					
			}
		}
		System.out.println(dp[10][10]);
	}
}
