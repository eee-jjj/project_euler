package level3;

import java.util.*;

public class P64 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 1;i<=10000;i++){
			//i=23;
			if((int)Math.sqrt(i)==Math.sqrt(i))
				continue;
			ArrayList<Pair> resd = new ArrayList<Pair>();
			resd.add(new Pair(0, 1));
			
			int x = i;
			int b = 0; 
			int c = 1;
			int k = 0;			
			
			while(true){
				k = (int)Math.floor((Math.sqrt(x)+b)/c);
				int b0 = b;
				int c0 = c;
				b = k*c0-b0;
				c = (x-(b0-k*c0)*(b0-k*c0))/c0;
				
				
				Pair p = new Pair(b,c);
				if(resd.contains(p)){
					int len = resd.size()-resd.indexOf(p);
					System.out.println(i + ": " + len);
					if(len%2==1)
						cnt++;
					break;
				}
				else
					resd.add(p);
			}
		}
		System.out.println(cnt);
	}

}
class Pair{
	int nom;
	int den;
	public Pair(int n,int d){
		nom = n;
		den = d;
	}
	@Override
	public boolean equals(Object o1){
		return nom==((Pair)o1).nom && den==((Pair)o1).den; 
	}
	public String toString(){
		return nom + ", " + den;
	}
}