package level2;
import java.util.*;
public class P43 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 0;
		for(long i=1023456789;i<=9876543210L;i++){
			String x = String.valueOf(i);
			if(check(x)){
				int x1 = Integer.parseInt(x.substring(1,4));
				int x2 = Integer.parseInt(x.substring(2,5));
				int x3 = Integer.parseInt(x.substring(3,6));
				int x4 = Integer.parseInt(x.substring(4,7));
				int x5 = Integer.parseInt(x.substring(5,8));
				int x6 = Integer.parseInt(x.substring(6,9));
				int x7 = Integer.parseInt(x.substring(7,10));
				
				if(x1 % 2==0 &&
						x2 % 3==0 &&
						x3 % 5==0 &&
						x4 % 7==0 &&
						x5 % 11==0 &&
						x6 % 13==0 &&
						x7 % 17==0)
					sum+=i;
			}
		}
		System.out.println(sum);
	}
	public static boolean check(String n){
		HashSet<Character> x = new HashSet<Character>();
		for(int i=0;i<n.length();i++){
			x.add(n.charAt(i));
		}
		return x.size()==10;
	}
}
