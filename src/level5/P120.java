package level5;

import java.util.*;

public class P120 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for(int a=3;a<=1000;a++){
			int a2 = a*a;
			
			HashSet<Integer> res = new HashSet<Integer>();
			int n = 1;
			while(true){
				if(n%2==0){
					res.add(2);
				}
				else{
					int x = (2*n*a) % a2;
					if(x!=2 && res.contains(x)){
						int max = -1;
						for(Integer ii:res){
							max = Math.max(ii, max);
						}
						System.out.println(a +":\t"+max);
						sum += max;
						break;
					}
					res.add(x);					
				}				
				n++;
			}
		}
		System.out.println(sum);
	}

}
