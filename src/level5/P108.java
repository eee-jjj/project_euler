package level5;

public class P108 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long n = 4;
		out: while(true){
			long x = n+1;
			int cnt = 0;
			while(true){
				if(n*x % (x-n)==0)
					cnt++;
				if(x>2*n){
					System.out.println(n +":\t"+ cnt);
					break;
				}
				x++;
				if(cnt>=1000){
					System.out.println(n);
					break out;
				}
			}
			n++;
		}
	}

}
