package level3;
import java.util.*;
public class P52 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i=1;
		while(true){
			char[] x1 = get(i);
			char[] x2 = get(i*2);
			char[] x3 = get(i*3);
			char[] x4 = get(i*4);
			char[] x5 = get(i*5);
			char[] x6 = get(i*6);
			
			if(Arrays.equals(x1, x2) && Arrays.equals(x2, x3) && Arrays.equals(x3, x4) && Arrays.equals(x4, x5) && Arrays.equals(x5, x6)){
				System.out.println(i);
				break;
			}
			i++;
		}
	}
	
	public static char[] get(int n){
		char[] res = String.valueOf(n).toCharArray();
		Arrays.sort(res);
		return res;
	}
}
