package level3;

import java.util.Arrays;

public class P51 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primes = new boolean[1000000];
		Arrays.fill(primes, true);
		
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				for(int j=i+i;j<primes.length;j=j+i){
					primes[j] = false;
				}
			}
		}
		
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				int[] sig = new int[10];
				String x = String.valueOf(i);
				for(int j=0;j<x.length();j++){
					sig[x.charAt(j)-'0']++;
				}
				for(int j=0;j<10;j++){
					if(sig[j]>=3){
						int cnt = 0;
						for(int k=0;k<10;k++){
							String y = x.replaceAll(String.valueOf((char)(j+'0')), String.valueOf((char)(k+'0')));
							if(!y.startsWith("0") && primes[Integer.parseInt(y)]){
								cnt++;
							}
						}
						if(cnt>=8){
							System.out.println(x);
							//System.exit(0);
						}
					}
				}
			}
		}
	}

}
