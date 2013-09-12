package level2;

public class P48 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		for(int i=11;i<=1000;i++){
			long p = 1;
			for(int j=0;j<i;j++){
				p *= i;
				p = p % 10000000000L;
			}
			sum += p;
			sum %= 10000000000L;
		}
		sum += 10405071317L;
		sum %= 10000000000L;
		System.out.println(sum);
	}

}
