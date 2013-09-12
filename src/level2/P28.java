package level2;

public class P28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 1;
		int loop = (1001-1)/2;
		int n = 1;
		int interval = 2;
		for(int i=0;i<loop;i++){
			for(int j=0;j<4;j++){
				n += interval;
				sum += n;
			}
			interval += 2;
		}
		System.out.println(sum);
	}

}
