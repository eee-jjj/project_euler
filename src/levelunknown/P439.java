package levelunknown;

public class P439 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//long m = (long)1e9;
		long cap = 3; 
		long ons = cap*cap;
		long sum = 0;
		
		for(long i=1;i<=cap;i++){
		    long times = cap/i;
		    long tmp = times*cap + (cap-times)*times;
		    System.out.println(tmp);
		    //sum += tmp*i;
		}
		System.out.println(sum);
		
		for(long i=2;i<=cap;i++){	
			long first = i*(i);
			long last = cap*i;
			long terms = cap-(i-1);
			long f = (cap/i)*2;
		    long tmp = (first+last)*terms/2*(f);
			sum += tmp;
			System.out.println(i+": "+tmp);
		}		
		System.out.println(sum);
		
		long test = 0;
		for(int i=1;i<=cap;i++){
			long _test = 0;
			for(int j=1;j<=cap;j++){
				int x = i*j;
				for(int k=1;k<=Math.sqrt(x);k++){
					if(x%k==0){
						_test += k;
						if(k!=x/k)
							_test += x/k;
					}
				}
			}
			test += _test;
			//System.out.println((_test-i*i)/2);
		}
		System.out.println("std: "+test);
		System.out.println(sum-test);
	}

}
