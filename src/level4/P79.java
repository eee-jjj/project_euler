package level4;

import java.util.*;
import java.io.*;

public class P79 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("keylog.txt"));
		String line = "";
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		
		for(int i=0;i<10;i++){
			map.put(i, new HashSet<Integer>());
		}
		
		while((line=br.readLine())!=null){
			int x1 = Integer.parseInt(line.substring(0,1));
			int x2 = Integer.parseInt(line.substring(1,2));
			int x3 = Integer.parseInt(line.substring(2,3));
			
			map.get(x1).add(x2);
			map.get(x1).add(x3);
			map.get(x2).add(x3);
		}
		
		for(int i=0;i<10;i++){
			System.out.println(i +": "+map.get(i));
		}
		
		br.close();
	}

}
class Rule{
	int f;
	int l;
	public Rule(int ff, int ll){
		f = ff;
		l = ll;
	}
	@Override
	public int hashCode(){
		return f*l;
	}
	@Override
	public boolean equals(Object o){
		Rule r2 = (Rule)o;
		return f==r2.f && l==r2.l;
	}
}
