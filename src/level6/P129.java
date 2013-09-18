package level6;

import java.util.ArrayList;

import util.PEUtil;

public class P129 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ArrayList<Integer> primes = PEUtil.generatePrimes(1100000);
//		for(int i=0;i<primes.size();i++){
//			if(primes.get(i) > 1000000)
//				System.out.println(primes.get(i));
//		}
		
		out: for(int i=1000003;i<=9000003;i++){
			//i = 1099997;
			if(i%2==0 || i%5==0)
				continue;
			int d = 9*i;
			
			int n = 1;
			long m = 10;
			while(true){
				m *= 10;
				n++;
				m = m % d;
				if(m==1){
					System.out.println(i +":\t"+n);
					if(n>1000000){
						System.out.println("~~~~~~~~~~~~~");
						break out;
					}
					break;
				}
			}
		}
	}

}
