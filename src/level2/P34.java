package level2;

public class P34 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] fact = new int[10];
		int p = 1;
		fact[0] = 1;
		for(int i=1;i<10;i++){
			p*=i;
			fact[i] = p;
			System.out.println(p);
		}
		for(int i=10;i<100000000;i++){
			int sum = 0;
			int x = i;
			while(x>0){
				int d = x%10;
				sum += fact[d];
				x = x/10;
			}
			if(sum==i){
				System.out.println(i);
			}
		}
	}
	
}
