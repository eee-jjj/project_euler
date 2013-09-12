package level4;

public class P94 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		for (long x = 2; x <= 353333333; x++) {
			Double t1 = Math.sqrt((3 * x - 1) * (x + 1));
			if (t1 == t1.longValue()) {
				if (t1.longValue() * t1.longValue() == (3 * x - 1) * (x + 1)) {
					long tmp = t1.longValue() * (x - 1);
					if (tmp < 0)
						System.out.println("Warning");
					if (tmp % 4 == 0 && 3 * x - 1 <= 1000000000) {
						sum += (x + x + x - 1);
					}
				}
			}
			Double t2 = Math.sqrt((3 * x + 1) * (x - 1));
			if (t2 == t2.longValue()) {
				if (t2.longValue() * t2.longValue() == (3 * x + 1) * (x - 1)) {
					long tmp = t2.longValue() * (x + 1);
					if (tmp < 0)
						System.out.println("Warning");
					if (tmp % 4 == 0 && 3 * x + 1 <= 1000000000) {
						sum += (x + x + x + 1);
					}
				}
			}
		}
		System.out.println(sum);
	}

}
