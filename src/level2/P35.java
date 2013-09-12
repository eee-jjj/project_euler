package level2;
import java.util.Arrays;


public class P35 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cnt = 0;
		int N = 100000000;
		boolean[] primes = new boolean[N];
		Arrays.fill(primes, true);
		for(int i=2;i<N;i++){
			if(primes[i]==false)
				continue;
			else{
				for(int j=i+i;j<N;j=j+i)
					primes[j]=false;
			}
		}
//		for(int i=0;i<N;i++)
//			System.out.println(i +" " +primes[i]);
		
		for(int i=2;i<N;i++){
			if(primes[i]==true){
				int prime = i;
				int len = (int)Math.log10(prime);
				boolean flag = true;
				for(int j=0;j<len;j++){
					int last = prime%10;
					prime = prime/10;
					prime = last*(int)Math.pow(10, len) + prime;
					flag = flag && primes[prime];
				}
				if(flag == true){
					cnt++;
					//System.out.println(prime);
				}
			}			
		}
		
		System.out.println(cnt);
	}

}
