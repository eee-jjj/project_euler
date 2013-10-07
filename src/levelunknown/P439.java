package levelunknown;

public class P439 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//long m = (long)1e9;
		long cap = 10; 
		long ons = cap*cap;
		long sum = 0;

		for(long i=1;i<=cap;i++){	
			long tmp = ((1+cap)*cap/2)*i*((cap/i)*2);
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
		System.out.println(test);
		System.out.println(sum-test);
	}

}
