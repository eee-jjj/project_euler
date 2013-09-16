package level5;

import java.util.*;

public class P118 {
	static long cnt = 0;
	static char[] std = {'1','2','3','4','5','6','7','8','9'};
	static ArrayList<Integer> primes;
	static HashMap<String, Integer> map;
	static ArrayList<String> list = new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		primes = generatePrimes(100000000);
		System.out.println(primes.size());
		
		map = new HashMap<String, Integer>();
		for(Integer prime:primes){
			char[] c = prime.toString().toCharArray();
			Arrays.sort(c);
			String nnew = new String(c);
			if(map.containsKey(nnew)){
				map.put(nnew, map.get(nnew)+1);
			}
			else{
				map.put(nnew, 1);
				list.add(nnew);
			}
		}
		System.out.println(map.size());
		System.out.println(list);
		
		pick(0, "" , 1);
		System.out.println(cnt);
	}
	static void pick(int index, String cur, long product){
		{
			char[] c = cur.toCharArray();
			int[] cc = new int[10];
			for (char ch : c)
				cc[ch - '0']++;
			for (int ccc : cc) {
				if (ccc > 1)
					return;
			}
		}		
		if(cur.length()>9)
			return;
		else if(cur.length()==9){
			char[] c = cur.toCharArray();
			Arrays.sort(c);
			if(Arrays.equals(c, std)){
				cnt += product;
				//System.out.println(cur);
			}
			return;
		}
		else{
			for(int i=index;i<list.size();i++){
				pick(i, cur+list.get(i).toString(), product*map.get(list.get(i)));
			}
		}
	}
	
	static ArrayList<Integer> generatePrimes (int cap){
		ArrayList<Integer> res = new ArrayList<Integer>();
		boolean[] primes = new boolean[cap+1];
		Arrays.fill(primes, true);
		for(int i=2;i<primes.length;i++){
			if(primes[i]==true){
				char[] x = String.valueOf(i).toCharArray();
				int[] sig = new int[10];
				for(char c:x){
					sig[c-'0']++;
				}
				boolean flag = true;
				for(int cnt:sig){
					if(cnt>1)
						flag = false;
				}
				if(flag == true && sig[0]==0)
					res.add(i);
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
				}
			}
		}
		return res;
	}
}
