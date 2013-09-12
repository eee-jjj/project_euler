package level2;
import java.util.*;
public class P49 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primes = new boolean[10000];
		Arrays.fill(primes, true);
		
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				for(int j=i+i;j<primes.length;j=j+i){
					primes[j] = false;
				}
			}
		}
		
		HashMap<String, ArrayList<Integer>> save = new HashMap<String, ArrayList<Integer>>();
		for(int i=1000;i<primes.length;i++){
			if(primes[i]==true){
				String x = String.valueOf(i);
				char[] xx = x.toCharArray();
				Arrays.sort(xx);
				String y = String.valueOf(xx);
				if(save.containsKey(y)){
					save.get(y).add(i);
				}
				else{
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(i);
					save.put(y, list);
				}
			}
		}
		
		for(String s:save.keySet()){
			if(save.get(s).size()>=3){
				ArrayList<Integer> x = save.get(s);
				out: for(int i=0;i<x.size();i++){
					for(int j=i+1;j<x.size();j++){
						for(int k=j+1;k<x.size();k++){
							if(x.get(i)+x.get(k)==2*x.get(j)){
								System.out.println(x.get(i)+" "+x.get(j)+" "+x.get(k));
								break out;
							}
						}
					}
				}
			}
		}
	}

}
