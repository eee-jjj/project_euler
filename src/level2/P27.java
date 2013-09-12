package level2;

public class P27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		int aa = Integer.MIN_VALUE;
		int bb = Integer.MIN_VALUE; 
		for(int a=-999;a<1000;a++){
			for(int b=2;b<1000;b++){
				int n = 0;
				int cnt = 0;
				while(true){
					int exp = n*n + a*n + b;
					if(exp<0){
						break;
					}
					if(!isPrime(exp)){
						break;
					}
					cnt++;
					n++;
				}
				if(cnt>max){
					max = cnt;
					aa = a;
					bb = b;
				}					
			}
		}
		System.out.println(max + " " + aa + " " + bb);
	}
	
	public static boolean isPrime(int n){
		double x = Math.sqrt(n);
		for(int i = 2;i<x;i++){
			if(n % i == 0)
				return false;
		}
		return true;
	}
}
