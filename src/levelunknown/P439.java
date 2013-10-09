package levelunknown;

public class P439 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//long m = (long)1e9;
		long cap = 10; 
		long sum = 0;	

		long base = 0;
		for(int j=1;j<=cap;j++){
            base += (cap/j)*j;
        }
		for(int i=1;i<=cap;i++){
		    long tmp = base;
		    long f= 0;
		    for(int k=2;k<=i;k++){
		    	if(i%k==0){
		    		for(int j=1;j<=cap;j++){
			        	long t = (cap/j-cap/(k*j));
			        	f += t*j*k;
			    	}
		    		System.out.println(f);
		    	}
		    }
		    tmp += f;
		    System.out.println(i+": "+tmp);
		    sum += tmp;
		}
		
		
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
			System.out.println(i+": "+(_test));
		}
		System.out.println("tst: " +sum);
		System.out.println("std: "+test);
		System.out.println(sum-test);
	}

}
