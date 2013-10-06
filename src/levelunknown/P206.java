package levelunknown;

public class P206 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long up = 1929394959697989990L;
		long dw = 1020304050607080900L;
		int cnt = 0;
		for(long i=((long)Math.sqrt(dw))/10*10;i<=(long)Math.sqrt(up);i+=10){
			long sq = i*i;
			String s = String.valueOf(sq);
			boolean flag = true;
			for(int j=0;j<=8;j++){
				if(s.charAt(2*j)-'0'!=(j+1)){
					flag = false;
				}
			}
			if(flag){
				cnt++;
				System.out.println(i);
			}
		}
		System.out.println(cnt);
	}

}
