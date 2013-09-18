package level6;

import java.util.*;

import util.PEUtil;

public class P128 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cap = 1000000;
		ArrayList<Integer> primess = PEUtil.generatePrimes(cap);
		HashSet<Integer> primes = new HashSet<Integer>(primess);
		ArrayList<Long> pd3 = new ArrayList<Long>();
		pd3.add(1L);
		
		long b = 2;
		int delta1 = 6;
		int delta2 = 12;
		for(int ring=0;ring<cap;ring++){
			
			ArrayList<Integer> n = new ArrayList<Integer>(3);
			n.add(delta1+1);
			n.add(delta1-1);
			n.add(delta1+delta2-1);
			
			if(primes.containsAll(n)){
				pd3.add(b);
			}
			
			long c = b+delta1+delta2-1;
			ArrayList<Integer> m = new ArrayList<Integer>(3);
			m.add(delta2-1);
			m.add(delta1+delta2-1);
			m.add(delta2+6-1);
			if(primes.containsAll(m)){
				pd3.add(c);
			}
			
			b += delta1;
			delta1 += 6;
			delta2 += 6;
		}
		Collections.sort(pd3);
		System.out.println(pd3.size());
		System.out.println(pd3);
		System.out.println(pd3.get(2000-1));
		
//		pd3.clear();
//		pd3.add(1);
//		
//		for(int ii=1;ii<cap;ii++){
//			int i = ii;
//			int base = 1;
//			int ring = 1;
//			while(i>base){
//				i-=base;
//				base = ring*6;
//				ring++;
//			}
//			i--;
//			int phase = 1;
//			if(ring>1){
//				phase = i/(ring-1);
//				i = i % (ring-1);
//			}
//			ring--;
//			
//			int[] n = new int[6];
//			// 0, last
//			if(phase==0&&i==0){ //0
//				n[0] = ii+1;
//				n[1] = gen(ring-1, 0, 0);
//				n[2] = gen(ring+1, 0, 0);
//				n[3] = n[2]-1;
//				n[4] = n[2]+1;
//				n[5] = gen(ring+2, 0, 0)-1;
//			} else if((phase==5&&i==ring-1)){ //last
//				n[0] = ii-1;
//				n[1] = gen(ring, 0, 0);
//				n[2] = gen(ring-1, 0, 0);
//				n[3] = n[1]-1;
//				n[4] = gen(ring+2, 0, 0)-1;
//				n[5] = n[4]-1;
//			} else {
//
//			}
//			Arrays.sort(n);
//			int c = 0;
//			for(int nei:n){
//				if(primes.contains(Math.abs(nei-ii))){
//					c++;
//				}
//			}
//			if(c==3){
//				pd3.add(ii);
//				System.out.println(ii + ": " + ring +","+ phase+","+i+","+Arrays.toString(n));
//			}
//		}
//		System.out.println(pd3.size());
//		System.out.println(pd3);
	}
	static int gen(int ring, int phase, int index){
		if(ring==0)
			return 1;
		int res = 2;
		for(int i=1;i<ring;i++){
			res += (i)*6;
		}
		res += phase*(ring);
		res += index;
		return res;
	}
}
