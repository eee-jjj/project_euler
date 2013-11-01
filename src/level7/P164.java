package level7;

import java.util.*;

public class P164 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long cnt = 0;
		int cap = 20;
//		for (int i = 9; i >= 1; i--) {
//			ArrayList<Integer> a = new ArrayList<Integer>();
//			a.add(i);
//			Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
//			stack.push(a);
//			while (!stack.isEmpty()) {
//				ArrayList<Integer> list = stack.pop();
//				if (list.size() == cap) {
//					cnt++;
//					// System.out.println(list);
//					continue;
//				}
//				int len = list.size();
//				int sum = list.get(len - 1);
//				if (len > 1) {
//					sum += list.get(len - 2);
//				}
//				if (sum > 9) {
//					continue;
//				}
//				int left = 9 - sum;
//				for (int j = 0; j <= left; j++) {
//					ArrayList<Integer> lcp = new ArrayList<Integer>(list);
//					lcp.add(j);
//					stack.push(lcp);
//				}
//			}
//		}
//		System.out.println(cnt);

		long[][][] dp = new long[10][10][cap + 1];
		for (int i = 0; i <= 9; i++) {
			dp[0][i][1] = 1;
		}
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9 - i; j++) {
				dp[i][j][2] = 1;
			}
		}
		for (int i = 3; i < cap; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9-j; k++) {
					int sum = k + j;
					for(int l=0;l<=9-sum;l++){
						dp[k][l][i] += dp[j][k][i-1];
					}
				}
			}
		}
		long ssum = 0;
		for (int j = 0; j <= 9; j++) {
			for (int k = 0; k <= 9-j; k++) {
				int sum = k + j;
				for(int l=1;l<=9-sum;l++){
					dp[k][l][cap] += dp[j][k][cap-1];
					ssum += dp[j][k][cap-1];
				}				
			}
		}
		System.out.println(ssum);
	}
}
