package level2;
import java.util.*;
public class P47 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] factors = new int[1000000];
		Arrays.fill(factors, 0);
		
		for(int i=2;i<factors.length;i++){
			if(factors[i]==0){
				for(int j=i+i;j<factors.length;j=j+i){
					factors[j]++;
				}
			}
		}
		
		for(int i=0;i<factors.length-10;i++){
			int x = 4;
			if(factors[i]==x && factors[i+1]==x && factors[i+2]==x && factors[i+3]==x){
				System.out.println(i);
				break;
			}
		}
	}

}
