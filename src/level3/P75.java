package level3;

/**
 * @author ytao
 *
 */
public class P75 {
	public static void main(String[] args){
		
		int L = 1500000;
		int[] comb = new int[L+5];
		int m = 1;
		int n = 1;
		for(m=1;m*m+n*n<L;m++){
			for(n=1;n<m;n++){
				if((m-n)%2 == 0)
					continue;
				if(gcd(m,n)!=1)
					continue;
				int a = m*m-n*n;
				int b = 2*m*n;
				int c = m*m+n*n;
				int l = a+b+c;
				if(l<comb.length)
					comb[l]++;
				for(int i=l+l;i<comb.length;i+=l)
					comb[i]++;
			}
		}
		int cnt = 0;
		for(int i=2;i<=L;i++){
			if(comb[i]==1)
				cnt++;
		}
		System.out.println(cnt);
	}
	public static int gcd(int a, int b){
		return b==0?a:gcd(b,a%b);
	}
}
