package levelunknown;

import java.util.ArrayList;
import java.util.Collections;

public class P221 {
	public static void main(String[] args) {
		ArrayList<Long> list = new ArrayList<>();
		int limit = 150000;
		for (long p = 1;; p++) {
			if (list.size() > limit && p > Math.pow(list.get(limit), 1.0 / 3)) {
				break;
			}
			for (long q = p + 1;q<=2*p; q++) {
				long up = 1 + p * p;
				long dn = q - p;
				if (up % dn == 0) {
					long r = up / dn + p;
					double adouble = 1.0 * p * r * q;
					if (adouble < Long.MAX_VALUE) {
						long a = (long) adouble;
						if (q * r - p * q - p * r == 1) {
							//System.out.println(p + ", " + q + ", " + r + ", " + a);
							int find = Collections.binarySearch(list, a);
							if (find >= 0) {
								System.out.println("~~~~~~same");
							} else {
								list.add(-(find + 1), a);
							}
						}
					}
				}
			}
			if (p % 1000 == 0) {
				System.out.println(p + " size: " + list.size());
				if (list.size() > limit + 10) {
					System.out.println(" x=" + list.get(limit - 1));
				}
			}

		}
		System.out.println(list.get(limit - 1));
	}
}
