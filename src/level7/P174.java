package level7;

import java.util.HashMap;

public class P174 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int cap = 1000000;
		
		for(int out=3;;out++){
			if( (out + out -2) * 2 > cap ){
				break;
			}
			for(int in = out-2;in>0;in-=2){
				int t = (out+in) * (out-in);
				if(t > cap)
					break;
				if(map.containsKey(t)){
					map.put(t, map.get(t)+1);
				}
				else{
					map.put(t, 1);
				}
			}
		}
		
		int cnt = 0;
		for(Integer i : map.values()){
			if(i>=1 && i<=10){
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
