package levelunknown;

import java.math.BigInteger;

public class P267 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int minx = 1000;
		for(double f=1e-10;f<1;f+=1e-6){
			double up = 9-1000*Math.log10(1-f);
			double dw = Math.log10((1+2*f)/(1-f));
			if((int)(up/dw)<minx){
				minx = (int)(up/dw);
				//System.out.println(minx);
			}
		}
		minx++;
		BigInteger sum = BigInteger.ZERO;
		BigInteger d = BigInteger.valueOf(2).pow(1000);
		for(int i=minx;i<=1000;i++){
			sum = sum.add(choose(1000, i));
		}
		double prob = sum.doubleValue() / d.doubleValue();
		System.out.println(prob);
	}
	static BigInteger choose(int x, int y){
		BigInteger res = BigInteger.ONE;
		for(int i=x;i>x-y;i--){
			res=res.multiply(BigInteger.valueOf(i));
		}
		for(int i=1;i<=y;i++){
			res=res.divide(BigInteger.valueOf(i));
		}
		return res;
	}
}
