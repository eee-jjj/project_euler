package level6;

import java.util.ArrayList;

public class P138 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long xbase = 76;
		long basea = 17;
		
		long up1 = 1;
		long up2 = 4;
		long dn1 = 0;
		long dn2 = 1;
		
		ArrayList<Long> res = new ArrayList<Long>();
		res.add(17L);
		
		for(long i=0;i<50;i++){
			long up = 0;
			long dn = 0;
			if(i % 2 == 0){
				up = 2*up2 + up1;
				dn = 2*dn2 + dn1;
				
			}
			else{
				up = 8*up2 + up1;
				dn = 8*dn2 + dn1;
			}
			
			up1 = up2;
			dn1 = dn2;
			up2 = up;
			dn2 = dn;
			if(i % 2 == 0){
				long nup1 = xbase * up + 20 * basea * dn;
				long ndn1 = xbase * dn + basea * up;
				if ((nup1 + 4) % 5 == 0 || (nup1 - 4) % 5 == 0) {
					System.out.println(nup1 + ", " + ndn1);
					res.add(ndn1);
					if (res.size() == 12)
						break;
				}
			}
		}
		long sum =0;
		for(int i=0;i<res.size();i++){
			sum += res.get(i);
		}
		System.out.println(res);
		System.out.println(sum);
	}

}
