package level6;

import java.util.*;

import util.PEUtil;

public class P137 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Long> res = new ArrayList<Long>();
		for(long a=1;;a++){
			long aa = 5*a*a+2*a+1;
			if(PEUtil.isPerfectSquare(aa)){
				System.out.println(a);
				res.add(a);
				if(res.size()==15)
					break;
			}
		}
	}

}
