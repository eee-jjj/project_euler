package level4;

public class P86 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int M = 2000;
		int bar = 10000;
		int[] cnt = new int[M+1];
		
		for(int i=1;i<=M;i++){
			for(int j=i;j<=M;j++){
				for(int k=j;k<=M;k++){
					int a = i+j;
					int b = k;
					double x = Math.sqrt(a*a+b*b);
					if((int)x == x){
						cnt[k]++;
					}
				}
			}
		}
		int[] sum = new int[M+1];
		int s = 0;
		for(int i=0;i<cnt.length;i++){
			s += cnt[i];
			sum[i] = s;
			if(sum[i]>bar){
				System.out.println(i + ":\t" + sum[i]);
				//break;
			}
		}
	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

}
