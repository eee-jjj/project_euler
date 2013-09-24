package level6;

public class P143 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 1.4;
		double y = -9.6;
		double k = -19.7/1.4;
		double b = 0;
		
		int cnt = 1;
		while(true){
			double m = y/(4*x);
			double v = (k-m)/(1+k*m);
			double kp = (m-v)/(1+v*m);
			b = y-kp*x;
			
			double delta = 4*b*b*kp*kp-4*(4+kp*kp)*(b*b-100);
			double xx = 0;
			double xxp = (-2*b*kp+Math.sqrt(delta))/(2*(4+kp*kp));
			double xxn = (-2*b*kp-Math.sqrt(delta))/(2*(4+kp*kp));
			if(Math.abs(x-xxp)<Math.abs(x-xxn)){
				xx = xxn;
			} else {
				xx = xxp;
			}				
						
			double yy = kp*xx+b;
			x = xx;
			y = yy;
			k = kp;
			
			cnt++;
			System.out.println(cnt +": "+x + ", " + y);
			double check = (10-b)/k;
			if(x<0.01 && x>-0.01 && y>0){
				System.out.println(cnt-1);
				break;
			}
		}
	}

}
