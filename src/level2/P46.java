package level2;
import java.util.*;
public class P46 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primes = new boolean[100000];
		Arrays.fill(primes, true);
		primes[0]=false;
		primes[1]=false;
		
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				for(int j=i+i;j<primes.length;j=j+i)
					primes[j]=false;
			}
		}
		
		int i=5;
		while(true){
			boolean flag = false;
			for(int j=1;j<=Math.sqrt(i/2);j++){
				int x = (i-2*j*j);
				if(primes[x]==true){
					flag = true;
					break;
				}
			}
			if(!flag && primes[i]==false){
				System.out.println(i);
				break;
			}
			i += 2;
		}
	}

}
