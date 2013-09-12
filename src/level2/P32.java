package level2;
import java.util.*;
public class P32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Integer> res = new HashSet<Integer>();
		
		for(int i=1;i<=9;i++){
			for(int j=1000;j<=9999;j++){
				for(int k=j;k<=9999;k++){
					if(i*j==k){
						HashSet<Integer> d = new HashSet<Integer>();
						d.add(i);
						d.add(j%10);
						d.add(j/1000);
						d.add((j/10)%10);
						d.add((j/100)%10);
						d.add(k%10);
						d.add(k/1000);
						d.add((k/10)%10);
						d.add((k/100)%10);
						if(d.size()==9 && !d.contains(0)){
							System.out.println(i + " " + j + " " + k);
							res.add(k);
						}
					}
				}
			}
		}
		
		for(int i=10;i<=99;i++){
			for(int j=100;j<=999;j++){
				for(int k=j;k<=9999;k++){
					if(i*j==k){
						HashSet<Integer> d = new HashSet<Integer>();
						d.add(i%10);
						d.add(i/10);
						d.add(j%10);
						d.add(j/100);
						d.add((j/10)%10);
						d.add(k%10);
						d.add(k/1000);
						d.add((k/10)%10);
						d.add((k/100)%10);
						if(d.size()==9 && !d.contains(0)){
							System.out.println(i + " " + j + " " + k);
							res.add(k);
						}
					}
				}
			}
		}
		
		int sum = 0;
		for(Integer i:res)
			sum+=i;
		System.out.println(sum);
	}
	
}
