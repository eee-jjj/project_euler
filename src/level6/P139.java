package level6;

public class P139 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long limit = 100000000L;
		double cap = Math.sqrt(limit/2); 
		long cnt = 0;
		for(long m=2;m<cap;m++){
			for(long n=1;n<m;n++){
				if((m-n)%2==0 || gcd(m,n)!=1)
					continue;
				long n1 = m*m-n*n;
				long n2 = 2*m*n;
				long x = Math.max(n1, n2);
				long y = Math.min(n1, n2);
				long z = m*m+n*n;
				
				if(z%(x-y)==0){
					long l = x+y+z;
					long count = limit/l;
					cnt += count;
					System.out.println(y+", "+x+", "+z+", count: "+count);
				}
			}
		}
		System.out.println(cnt);
	}
	static long gcd(long a, long b){
		return a==0?b:gcd(b%a,a);
	}
}
