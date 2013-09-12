package level2;
import java.util.*;

public class P38 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		
		int x = 1;
		while(x<50000000){
			int len = 0;
			String res = "";
			
			int i = 1;
			while(len<9){
				res += x*i;
				i++;
				len = res.length();
			}
			if(len==9 && is(res)){
				if(max<Integer.parseInt(res)){
					max = Integer.parseInt(res);
					System.out.println(max);
				}
			}
			x++;
		}
	}
	
	public static boolean is(String n){
		for(int i=1;i<=9;i++){
			if(!n.contains(String.valueOf(i)))
				return false;
		}
		return true;
	}
}
