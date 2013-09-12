package level3;

/**
 * @author ytao
 *
 */
public class P71 {
	public static void main(String[] args){
		for(int i=1000000;i>1;i--){
			double b = 3*i-1;
			b = b/7;
			if(b==(int)b){
				int bb = (int)b;
				if(gcd(bb, i)==1){
					System.out.println(bb + "/" + i);
					break;
				}					
			}
		}
	}
	public static int gcd(int a,int b){
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
