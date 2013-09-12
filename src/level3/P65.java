package level3;

import java.math.BigInteger;

public class P65 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger[] nom = new BigInteger[120];
		BigInteger[] den = new BigInteger[120];
		
		int[] constant = new int[120];
		int cnt = 2;
		for(int i=0;i<120;i++){
			if(i%3==0 || i%3==2)
				constant[i] = 1;
			else{
				constant[i] = cnt;
				cnt += 2;
			}
		}
		
		int N = 98;
		//N = N-1;
		nom[0] = BigInteger.ONE;
		den[0] = new BigInteger(String.valueOf(constant[N]));
		
		int index = 1;
		for(int i=N;i>0;i--){
			den[index] = den[index-1].multiply(new BigInteger(String.valueOf(constant[i-1]))).add(nom[index-1]);
			nom[index] = den[index-1];
			
			System.out.println(nom[index] + "/" + den[index]);
			
			index++;			
		}
		BigInteger res = den[index-1].multiply(new BigInteger("2")).add(nom[index-1]);
		System.out.println(res + "/" + den[index-1]);
		String s = res.toString();
		int sum = 0;
		for(int i=0;i<s.length();i++){
			sum += s.charAt(i) - '0';
		}
		System.out.println(sum);
	}

}
