package level4;

import java.util.Arrays;
import java.util.HashSet;

public class P88 {
	static int stop = 12000;
	static int N = 2*stop;
	static int[] k = new int[N+1]; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Arrays.fill(k, Integer.MAX_VALUE);
		for(int i=2;i<=14;i++){
			go(i, 1, 0, 2, 0);
		}
		for(int i=2;i<=stop;i++){
			System.out.println("k="+i+":"+k[i]);
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=2;i<=stop;i++)
			set.add(k[i]);
		int sum = 0;
		for(Integer i:set)
			sum+=i;
		System.out.println(sum);
	}
	static void go(int remain, int product, int sum, int lowb, int cnt){
		if(remain==0){
			int kk = product-sum+cnt;
			if(product<k[kk]){
				k[kk] = product;
			}
			return;
		}
		for(int i=lowb;i<=N;i++){
			if(product*i>N)
				return;
			go(remain-1, product*i, sum+i, i, cnt+1);
		}
	}

}
