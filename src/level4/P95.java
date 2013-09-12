package level4;

import java.util.*;
import java.util.Map.Entry;

public class P95 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[] primes = new boolean[1000005];
		Arrays.fill(primes, true);
		
		HashMap<Integer, Integer>[] factors = new HashMap[primes.length];
		for(int i=0;i<factors.length;i++)
			factors[i] = new HashMap<Integer,Integer>();
		
		for(int i=2;i<primes.length;i++){
			if(primes[i]){
				for(int j=i+i;j<primes.length;j+=i){
					primes[j] = false;
					factors[j].put(i, 1);
				}
				int p = 2;
				for(int j=i*i;j<primes.length;j*=i){
					for(int k=1;k*j>0 && k*j<primes.length;k++){
						factors[k*j].put(i, p);
					}
					p++;
				}
			}
		}
		
		int[] sum = new int[1000001];
		for(int i=2;i<sum.length;i++){
			HashMap<Integer,Integer> factor = factors[i];
			if(factor.size()==0){
				sum[i]=1;
				continue;
			}
			int p = 1;
			for(Entry<Integer, Integer> e:factor.entrySet()){
				int prime = e.getKey();
				int ak = e.getValue();
				ak++;
				long pp = (long)(Math.pow(prime, ak)-1)/(prime-1);
				p *= pp;
			}
			sum[i]=p-i;
		}
		
		//System.out.println(Arrays.asList(sum));
		boolean[] to1 = new boolean[1000001];
		int max = 0;
		ArrayList<Integer> hmax = new ArrayList<Integer>();
		for(int i=2;i<sum.length;i++){
			ArrayList<Integer> save = new ArrayList<Integer>();
			save.add(i);
			int ii = sum[i];
			while(true){
				if(ii>0 && ii<sum.length && ii!=1){
					//vis[ii] = true;
					if(save.contains(ii)){
						if(save.size()-save.indexOf(ii)>max){
							save.add(ii);
							hmax = save;
							max = save.size();
							System.out.println(max +":" +hmax);
						}							
						break;
					}
					else{
//						if(sum[ii]<0)
//							System.out.println(ii + " " +sum[ii]);
						save.add(ii);
						ii = sum[ii];
					}						
				}
				else if(ii==1){
					for(Integer x:save)
						sum[x]=1;
					break;
				}
				else
					break;
			}
		}
		System.out.println(hmax);
	}
}
