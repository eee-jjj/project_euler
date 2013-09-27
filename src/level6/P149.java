package level6;

public class P149 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 2000;
		int[][] m = new int[len][len];
		
		int[] k = new int[len*len];
		for(int i=1;i<=55;i++){
			k[i-1] = (int)((100003 - 200003*i + 300007L*i*i*i)%1000000 - 500000);
		}
		for(int i=56;i<=4000000;i++){
			k[i-1] = (k[i-1-24] + k[i-1-55] + 1000000)%1000000 - 500000;
		}
		int pp = 0;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				m[i][j] = k[pp];
				pp++;
			}
		}
		
		long hmax = Integer.MIN_VALUE;
		for(int i=0;i<len;i++){
			long sum = 0;
			for(int j=0;j<len;j++){
				sum += m[i][j];
				if(sum<0)
					sum = 0;
			}
			hmax = Math.max(hmax, sum);
		}
		
		long vmax = Integer.MIN_VALUE;
		for(int i=0;i<len;i++){
			long sum = 0;
			for(int j=0;j<len;j++){
				sum += m[j][i];
				if(sum<0)
					sum = 0;
			}
			vmax = Math.max(vmax, sum);
		}
		
		long admax = Integer.MIN_VALUE;
		for(int i=0;i<1;i++){
			for(int j=0;j<len;j++){
				long sum = 0;
				int l = 0;
				while(j-l>=0){
					sum+=m[i+1][j-l];
					if(sum<0)
						sum = 0;
					l++;
				}
				admax = Math.max(admax, sum);
			}			
		}
		
		long dmax = Integer.MIN_VALUE;
		for(int i=0;i<1;i++){
			for(int j=len-1;j>=0;j--){
				long sum = 0;
				int l = 0;
				while(j+l<=len-1){
					sum+=m[i+l][j+l];
					if(sum<0)
						sum = 0;
					l++;
				}
				dmax = Math.max(dmax, sum);
			}
		}
		
		long max = Math.max(vmax, hmax);
		max = Math.max(max, dmax);
		max = Math.max(max, admax);
		
		System.out.println(max);
	}

}
