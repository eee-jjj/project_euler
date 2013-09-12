package level4;

import java.math.BigInteger;
import java.util.*;

public class P100 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//long x = 1000000000000L;
		long[] x = {7,17};
		long[] y = {5,12};
		int cnt = 0;
		while(true){
			long xx = 2*x[1]+x[0];
			long yy = 2*y[1]+y[0];
			
			x[0] = x[1];
			x[1] = xx;
			y[0] = y[1];
			y[1] = yy;
			
			if(cnt%2==0){
				System.out.println((yy+1)/2 +"/"+ (xx+1)/2);
				if(xx>1000000000000L){
					System.out.println("Warning~~~~~~~~~~~~~~~~~~~~~~");
					break;
				}
			}
		}
	}
	public static long gcd(long a, long b){
		return b==0?a:gcd(b,a%b);
	}
}
