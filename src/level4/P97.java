package level4;

public class P97 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long mask = 10000000000L;
		long p = 1;
		for(int i=0;i<7830457;i++){
			p *= 2;
			p %= mask;
		}
		System.out.println(p);
		p *= 28433;
		p += 1;
		System.out.println(p%mask);
	}

}
