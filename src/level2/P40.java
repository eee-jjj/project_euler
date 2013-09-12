package level2;

public class P40 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder x = new StringBuilder();
		
		for(int i=1;i<1000000;i++){
			x.append(String.valueOf(i));
		}
		
		int p = 1;
		int a = 1;
		for(int i=0;i<7;i++){
			int d = x.charAt(a-1) - '0';
			System.out.println(d);
			p = p*d;
			a = a*10;
		}
		
		System.out.println(p);
	}

}
