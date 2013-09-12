package level2;
import java.util.*;
public class P30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] save = new int[10];
		save[0] = 0;
		for(int i=1;i<10;i++){
			int p = 1;
			for(int j=0;j<5;j++){
				p = p*i;
			}
			save[i] = p;
		}
		for(int i=0;i<10;i++)
			System.out.println(save[i]);
		long totalsum = 0;
		for(int i=1 ;i<9999999 ;i++){
			int n = i;
			int sum = 0;
			while(n>0){
				int d = n%10;
				n = n/10;
				sum += save[d];
			}
			if(sum == i){
				System.out.println(sum);
				totalsum += sum;
			}
		}
		System.out.println(totalsum-1);
	}
}
