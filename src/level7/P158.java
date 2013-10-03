package level7;

public class P158 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=3;i<=26;i++){
			long c = c(i);
			
			int[] num = new int[i];
			for(int j=1;j<num.length;j++){
				num[j]=j;
			}
			
			long count = 0;
			for(int a=0;a<num.length;a++){
				for(int b=a+1;b<num.length;b++){
					long subcnt = 1;
					for(int test=0;test<num.length;test++){
						if(test==a || test==b)
							continue;
						int tmp = test>a ? 1 : 0;
						tmp += (test<b ? 1 : 0);
						subcnt *= tmp;
					}
					count += subcnt;
				}
			}
			long r = c*count;
			System.out.println(r);
		}
	}
	public static long c(int n){
		if(n>13)
			return c(26-n);
		long res = 1;
		for(long i=26;i>26-n;i--){
			res *= i;
		}
		for(long i=1;i<=n;i++){
			res /= i;
		}
		return res;
	}
}
