package level3;

import java.math.BigInteger;
import java.util.ArrayList;

public class P66 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 1000;
		BigInteger max = BigInteger.ZERO;
		int D = -1;
		for(int i=1;i<=N;i++){
			if((int)Math.sqrt(i)==Math.sqrt(i))
				continue;
			ArrayList<Pair> resd = new ArrayList<Pair>();
			ArrayList<Integer> expa = new ArrayList<Integer>();
			resd.add(new Pair(0, 1));
			
			int x = i;
			int b = 0; 
			int c = 1;
			int k = 0;			
			
			while(true){
				k = (int)Math.floor((Math.sqrt(x)+b)/c);
				expa.add(k);
				int b0 = b;
				int c0 = c;
				b = k*c0-b0;
				c = (x-(b0-k*c0)*(b0-k*c0))/c0;
				
				
				Pair p = new Pair(b,c);
				if(resd.contains(p)){
					break;
				}
				else
					resd.add(p);
			}
			//System.out.println(i + ","+ expa);
			
			BigInteger h_1 = BigInteger.ONE;
			BigInteger h_2 = BigInteger.ZERO;
			BigInteger k_1 = BigInteger.ZERO;
			BigInteger k_2 = BigInteger.ONE;
			BigInteger intgr = new BigInteger(String.valueOf(expa.remove(0)));
			BigInteger hn = h_1.multiply(intgr).add(h_2);
			BigInteger kn = k_1.multiply(intgr).add(k_2);
			
			int index = 0;
			while(true){
				if(hn.multiply(hn).subtract(kn.multiply(kn).multiply(new BigInteger(String.valueOf(i)))).equals(BigInteger.ONE)){
					System.out.println(i +"\t"+ hn +"\t"+kn);
					if(hn.compareTo(max)>0){
						max = hn;
						D = i;
					}
					break;
				}
				h_2 = h_1;
				k_2 = k_1;
				h_1 = hn;
				k_1 = kn;
				hn = h_1.multiply(new BigInteger(String.valueOf(expa.get(index%expa.size())))).add(h_2);
				kn = k_1.multiply(new BigInteger(String.valueOf(expa.get(index%expa.size())))).add(k_2);
				
				index++;
			}
		}
		System.out.println(max +"\t"+ D);
	}

}
