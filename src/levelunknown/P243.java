package levelunknown;

import java.util.*;

import util.PEUtil;

public class P243 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long i = 223092870; // = 2*3*5*7*11*13*17*19*23*27
		long tarUp = 15499;
		long tarDw = 94744;
		
		long t = 36495360;

		System.out.println(1.0*tarUp/tarDw+"~~~~~~~~~~~~~");
		long ii = 0;
		long tt = 0;
		for(int j=1;j<35;j++){
			ii += i;
			tt += t;
			double v= (1.0*tt/(ii-1));
			if(v<1.0*tarUp/tarDw)
				System.out.println("~~~~"+j +": "+(1.0*tt/(ii-1))+", "+ii);
			else
				System.out.println(j +": "+(1.0*tt/(ii-1)));
		}
	}
}
