package level4;

import java.util.Arrays;

public class P91 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 50;
		int cnt = 0;
		for(int x1=0;x1<=N;x1++){
			for(int y1=0;y1<=N;y1++){
				if(x1==0 && y1==0)
					continue;
				
				for(int x2=0;x2<=N;x2++){
					for(int y2=0;y2<=N;y2++){
						if(x2==0 && y2==0)
							continue;
						if(x1==x2 && y1==y2)
							continue;
						int[] side = new int[3];
						side[0] = x1*x1+y1*y1;
						side[1] = x2*x2+y2*y2;
						side[2] = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
						
						Arrays.sort(side);
						if(side[0]+side[1]==side[2]){
							System.out.println("x1:"+x1+"\t"+"x1:"+y1+"\t"+"x2:"+x2+"\t"+"y2:"+y2+"\t");
							cnt++;
						}							
					}
				}
			}
		}
		System.out.print(cnt/2);
	}

}
