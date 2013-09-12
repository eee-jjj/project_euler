package level2;

public class P36 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<1000000;i++){
			if(isPalin(String.valueOf(i)) && isPalin(base2(i)))
				sum += i;
		}
		System.out.println(sum);
	}
	
	public static boolean isPalin(String n){
		int p1 = 0;
		int p2 = n.length()-1;
		while(p1<p2){
			if(n.charAt(p1)!=n.charAt(p2))
				return false;
			p1++;
			p2--;
		}
		return true;
	}
	
	public static String base2(int n){
		return Integer.toBinaryString(n);
	}
}
