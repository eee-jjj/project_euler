package level7;


public final class P150 {
	
	public static void main(String[] args) {
		int row = 1000;
		long t = 0;
		
		long[] s = new long[500500];
		long m = 1024*1024;
		for(int k=1;k<500500;k++){
			t = (615949*t + 797807) % m;
			s[k-1] = t-m/2;
		}
		
		long[][] sum = new long[row][row+1];
		int index = 0;
		for(int i=0;i<sum.length;i++){
			for(int j=0;j<=i;j++){
				sum[i][j+1] = sum[i][j] + s[index];
				index++;
			}
		}
		
		long res = Integer.MAX_VALUE;
		for(int i=0;i<sum.length;i++){
			for(int j=0;j<=i;j++){
				long tmp = 0;
				for(int h=0;h<row-i;h++){
					tmp += sum[i+h][j+h+1] - sum[i+h][j];
					res = Math.min(tmp, res);
				}
			}
		}
		System.out.println(res);
	}	
}
