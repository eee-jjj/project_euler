package level7;

public class P173 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cap = 1000000;
		int cnt = 0;
		for(long i=1;;i++){
			if(i*i-(i-2)*(i-2)>cap)
				break;
			int incnt = 0;
			for(long j=i-2;j>=1;j-=2){
				incnt++;
				long delta = i*i-j*j;
				//System.out.println(delta + ": " + i + ", " + j);				
				if(delta>cap){
					cnt += (incnt-1);
					incnt = 0;
					break;
				}				
			}
			cnt += incnt;
		}
		System.out.println(cnt);
	}

}
