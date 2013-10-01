package level6;

import util.PEUtil;

public class P142 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int cap = 1000;
		
		for(int n1=1;n1<cap;n1++){
			for(int n3=1;n3<n1;n3++){
				for(int n5=1;n5<n3;n5++){
					int y2 = n1*n1-n3*n3+n5*n5;
					int z2 = n5*n5-n1*n1+n3*n3;
					int x2 = n1*n1+n3*n3-n5*n5;
					if(x2>0 && y2>0 && z2>0 && x2%2==0 && y2%2==0 && z2%2==0){
						int x = x2/2;
						int y = y2/2;
						int z = z2/2;
						int n22 = x-y;
						int n42 = x-z;
						int n62 = y-z;
						
						if(PEUtil.isPerfectSquare(n22) && PEUtil.isPerfectSquare(n42) && PEUtil.isPerfectSquare(n62)){
							System.out.println(x+", "+y+", "+z);
						}
					}
				}
			}
		}
	}

}
