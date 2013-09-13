package level5;

import java.util.*;

public class P109 {
	static int cnt = 0;
	static int cap = 100;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Dart> darts = new ArrayList<Dart>();
		ArrayList<Dart> doubledarts = new ArrayList<Dart>();
		for(int i=1;i<=20;i++){
			Dart is = new Dart(i, false);
			Dart id = new Dart(i*2, true);
			Dart it = new Dart(i*3, false);
			darts.add(is);
			darts.add(id);
			darts.add(it);
			doubledarts.add(id);
		}
		darts.add(new Dart(0, false));
		darts.add(new Dart(25, false));
		darts.add(new Dart(50, true));
		doubledarts.add(new Dart(50, true));
		
		for(int i=0;i<darts.size();i++){
			for(int j=i;j<darts.size();j++){
				
				for(int k=0;k<doubledarts.size();k++){
					int sum = darts.get(i).val + darts.get(j).val + doubledarts.get(k).val;
					if(sum<cap)
						cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
class Dart implements Comparable<Dart>{
	int val;
	boolean db = false;
	public Dart(int val, boolean d){
		this.val = val;
		db = d;
	}
	@Override
	public int compareTo(Dart d){
		return val-d.val;
	}
	@Override
	public String toString(){
		return "("+val+","+db+")";
	}
}
