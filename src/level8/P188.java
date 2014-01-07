package level8;

import java.util.ArrayList;
import java.util.HashSet;

public class P188 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long b = 1777;
		int times = 1855;
		int m = 100000000;
		ArrayList<Integer> save = new ArrayList<Integer>();
		save.add(m);
		while(times>0){
			long p = 1;
			HashSet<Long> set = new HashSet<Long>();
			for(int i=0;;i++){
				p *= b;
				p %= m;
				//System.out.println(p);
				if(set.contains(p)){
					//System.out.println("~~~~~");
					times--;
					System.out.println(times+": "+set.size());
					if(set.size()!=1){
						save.add(set.size());
					}
					m = set.size();
					break;
				}
				else{
					set.add(p);
				}
			}
		}
		long base = 1777;
		long t = 0;
		for(int i=save.size()-1;i>=0;i--){
			int mm = save.get(i);
			long p = 1%mm;
			for(int j=0;j<t;j++){
				p*=base;
				p%=mm;
			}
			t = p;
		}
		System.out.println(t);
	}
}
