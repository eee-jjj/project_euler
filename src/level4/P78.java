package level4;

/**
 * @author ytao
 *
 */
public class P78 {
	
	public static void main(String[] a){
		int N = 1000000;
	
		int[] dp1 = new int[N+1];
		int[] dp2 = new int[N+1];
		
		for(int i=1;i<N+1;i++){
			dp1[i] = 1;
		}
		for(int i=2;i<N+1;i++){
			dp2[1] = 1; 
			for(int j=i;j<N+1;j++){
				if(j<=i)
					dp2[j] = dp1[j]+1;
				else
					dp2[j] = dp1[j] + dp2[j-i];
			}
			dp1 = dp2;
			//dp2 = new int[N+1];
			if(dp2[i] % 1000000 == 0){
				System.out.println(i);
				System.exit(0);
			}
		}
		//System.out.println(dp2[N]);
	}
}
