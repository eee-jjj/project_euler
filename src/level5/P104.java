package level5;

import java.math.BigInteger;
import java.util.Arrays;

public class P104 {
	static char[] std = {'1','2','3','4','5','6','7','8','9'};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger f1t = BigInteger.valueOf(1);				
		BigInteger f2t = BigInteger.valueOf(1);
		BigInteger f1h = BigInteger.valueOf(1);				
		BigInteger f2h = BigInteger.valueOf(1);
		
		int i = 3;
		boolean flag = false;
		while(true){
			BigInteger f3t = f2t.add(f1t);
			String f3tstr = f3t.toString();
			if(f3tstr.length()>9){
				f3t = new BigInteger(f3tstr.substring(f3tstr.length()-9));
			}
			if(check(f3t.toString())){
				//System.out.println(i);
			}
			f1t = f2t;
			f2t = f3t;
			
			BigInteger f3h = f2h.add(f1h);
			if(f3h.toString().length()>f2h.toString().length())
				flag = true;
			else
				flag = false;
			String f3hstr = f3h.toString();
			if(f3hstr.length()>=9 && check(f3hstr.substring(0,9))){
				//System.out.println(i);
			}
			if(f3hstr.length()>16){
				if(flag==true){
					f1h = new BigInteger(f2h.toString().substring(0,15));
				} else{
					f1h = new BigInteger(f2h.toString().substring(0,16));
				}				
				f2h = new BigInteger(f3hstr.substring(0,16));
			} else {
				f1h = f2h;
				f2h = f3h;
			}
			
			if(check(f3t.toString()) && f3hstr.length()>=9 && check(f3hstr.substring(0,9))){
				System.out.println(i);
			}			
			i++;
		}
	}
	static boolean check(String x){
		if(x.length()<9)
			return false;
		char[] c = x.toCharArray();
		Arrays.sort(c);
		
		if(Arrays.equals(std, c))
			return true;
		else
			return false;
	}
}
