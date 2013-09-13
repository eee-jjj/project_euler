package level5;

import java.util.Arrays;

public class P113 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] w = new int[101];
		int[] w0 = new int[101];
		
		w[1]=9;
		w0[1]=9;
		w[2]=45;
		w0[2]=45;
		
		int[] c9 = {1,9,36,84,126,126,84,36,9,1};
		long[][] yh = new long[101][101];
		
		for(int i=1;i<yh.length;i++){
			for(int j=1;j<=i;j++){
				if(j==1)
					yh[i][j] = 1;
				else
					yh[i][j] = yh[i-1][j-1]+yh[i-1][j];
			}
			//System.out.println(Arrays.toString(yh[i]));
		}
		long summ = 99;
		long summ0 = 54;
		for(int i=3;i<=100;i++){
			long sum = 0;
			long sum0 = 0;
			for(int j=1;j<=9;j++){
				long tmp = c9[j]*yh[i][j];
				if(j==1){
					sum+=tmp;
					sum0+=tmp;
				}
				else{
					sum+=tmp*2;
					sum0+=tmp;
				}
			}
			summ += sum+summ0;
			summ0 += sum0;
			System.out.println(i+":\t"+summ);
		}
	}

}
