package level4;
import java.math.BigInteger;


public class P80 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<=100;i++){
			double sq = Math.sqrt(i);
			if(sq == (int)sq)
				continue;
			
			int cnt = 0;
			BigInteger c = BigInteger.valueOf(i);
			BigInteger p = BigInteger.valueOf(0);
			for(int j=0;j<100;j++){
				int x = -1;
				for(int k=1;k<=10;k++){
					if(BigInteger.valueOf(k).multiply(p.multiply(BigInteger.valueOf(20)).add(BigInteger.valueOf(k))).compareTo(c)>0){
						x = k-1;
						break;
					}
				}
				BigInteger y = BigInteger.valueOf(x).multiply(p.multiply(BigInteger.valueOf(20)).add(BigInteger.valueOf(x)));
				p = p.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(x));
				c = c.subtract(y).multiply(BigInteger.valueOf(100));
				
				cnt += x;
			}
			sum += cnt;
			//System.out.println(cnt);
		}
		System.out.println(sum);
	}

}
