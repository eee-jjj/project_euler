package level8;

import java.util.ArrayList;

public class P191 {
	static long cnt = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		go(0,0,0);
		System.out.println(cnt);
	}
	static void go(int n, int L, int curA){
		if(L>1)
			return;
		if(curA==3)
			return;
		if(n==30){
			cnt++;
			return;
		}
		// O
		go(n+1,L, 0);
		// L
		go(n+1,L+1,0);
		// A
		go(n+1,L, curA+1);
	}
}
