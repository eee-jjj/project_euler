package level2;
import java.util.Arrays;


public class P37 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 1000000;
		boolean[] primes = new boolean[N];
		Arrays.fill(primes, true);
		primes[1]=false;
		primes[2]=true;
		for(int i=2;i<N;i++){
			if(primes[i]==false)
				continue;
			else{
				for(int j=i+i;j<N;j=j+i)
					primes[j]=false;
			}
		}
		int sum = 0;
		
		out: for(int i=11;i<N;i++){
			int n = i;
			if(primes[n]==true){
				while(n>0){
					n=n/10;
					if(primes[n]==false)
						continue out;
				}
				String nn = String.valueOf(i);
				int len = nn.length();
				for(int j=0;j<len;j++){
					nn = nn.substring(1);
					if(nn.length()>0 && primes[Integer.parseInt(nn)] == false){
						continue out;
					}
				}
				sum+=i;
			}
			
		}
		System.out.println(sum);	
	}

}
