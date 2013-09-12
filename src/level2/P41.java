package level2;
import java.util.*;

public class P41 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[] prime = new boolean[10000000];
		Arrays.fill(prime, true);
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == true) {
				for (int j = i + i; j < prime.length; j = j + i) {
					prime[j] = false;
				}
			}
		}

		for (int i = prime.length - 1; i > 0; i--) {
			if (prime[i]) {
				String p = String.valueOf(i);
				char[] sig = p.toCharArray();
				Arrays.sort(sig);

				int len = p.length();
				char[] std = new char[len];
				for (int j = 1; j <= len; j++) {
					std[j - 1] = (char) (j + '0');
				}
				if (Arrays.equals(std, sig)) {
					System.out.println(i);
					return;
				}
			}
		}
	}

}
