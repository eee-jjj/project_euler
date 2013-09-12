package level4;

import java.util.*;
import java.io.*;

public class P81 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileReader("matrix.txt"));
		int[][] m = new int[80][80];
		for(int i=0;i<80;i++){
			String line = sc.nextLine();
			String[] ss = line.split(",");
			for(int j=0;j<80;j++){
				m[i][j]=Integer.parseInt(ss[j]);
			}
		}		
		sc.close();
		
		int[][] dp = new int[80][80];
		int sum = 0;
		for(int i=0;i<80;i++){
			sum+=m[0][i];
			dp[0][i] = sum;
		}
		sum = 0;
		for(int i=0;i<80;i++){
			sum+=m[i][0];
			dp[i][0] = sum;
		}
		for(int i=1;i<80;i++){
			for(int j=1;j<80;j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
			}
		}
		System.out.println(dp[79][79]);
	}

}
