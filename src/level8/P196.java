package level8;

import java.util.ArrayList;

import util.PEUtil;

public class P196 {
	
	static ArrayList<Integer> primes = PEUtil.generatePrimes(10000000);
	static ArrayList<Integer> ps;
	
	public static void main(String[] args) {
		long cap1 = 5678027;
		long cap2 = 7208785;
		long sum = cal(cap1) + cal(cap2);
		System.out.println(sum);
	}
	static long cal(long cap){
		ps = PEUtil.generatePrimes(10000000);
		long start = 0;
		for (long i = 1; i < cap; i++) {
			start += i;
		}
		
		long sum = 0;
		
		long end = start + cap;
		start = start + 1;
		System.out.println(start + "," + end);
		if(start % 2 == 0){
			start += 1;
		}
		boolean[] sieve = new boolean[(int)cap];
		for(long i=start;i<=end;i+=2){
			
			if(sieve[(int)(i-start)]){
				continue;
			}
			
			int p = isP(i);
			if(p==1){
				long[] nb = nb(i, cap);
				int cnt = 0;
				for(int j=0;j<nb.length;j++){
					if(isP(nb[j])==1){
						cnt++;
					}
				}
				if(cnt>=2){
					sum += i;
				}
				else if(cnt==1){
					for(int j=0;j<nb.length;j++){
						if(isP(nb[j])==1){
							long[] nnb;
							if(j<3)
								nnb = nb(nb[j], cap-1);
							else
								nnb = nb(nb[j], cap+1);
							int c = 0;
							for(int k=0;k<nnb.length;k++){
								if(isP(nnb[k])==1){
									c++;
								}
							}
							if(c>=2){
								sum += i;
							}
							break;
						}
					}
				}
			} else {
				for(long j=i;j<=end;j+=p){
					sieve[(int)(j-start)] = true;
				}
			}
		}
		System.out.println(sum);
		return sum;
	}
	static long[] nb(long i, long line){
		long[] nb = new long[6];
		nb[0] = i - (line-1);
		nb[1] = nb[0]-1;
		nb[2] = nb[0]+1;
		nb[3] = i + line;
		nb[4] = nb[3]-1;
		nb[5] = nb[3]+1;
		return nb;
	}
	static int isP(long n){
		int max = (int)Math.sqrt(n);
		for(int i=0;i<primes.size() && primes.get(i)<=max;i++){
			if(n % primes.get(i) == 0){
				return primes.get(i);
			}
		}
		return 1;
	}
}
