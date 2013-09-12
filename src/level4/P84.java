package level4;

import java.util.*;
import java.math.*;

public class P84 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random seed = new Random();
		int N = 4;		
		double times = 10000000;
		int pos = 0;		
		int doublecnt = 0;
		int[] freq = new int[40];
		int cc = 0;
		int ch = 0;
		
		for(int i=0;i<times;i++){
			int d1 = seed.nextInt(N) + 1;
			int d2 = seed.nextInt(N) + 1;
			
			if(d1==d2)
				doublecnt++;
			else
				doublecnt=0;
			
			if(doublecnt==3){
				pos = 10;
				freq[pos]++;
				continue;
			}
			
			int d = d1+d2;
			pos = (pos+d)%40;
			
			if(pos==30){
				pos = 10;
				freq[pos]++;
				continue;
			}
			if(pos==1||pos==17||pos==33){
				cc = (cc+1)%16;
				switch(cc){
				case 0: pos = 0;break;
				case 1: pos = 10;break;
				}
				freq[pos]++;
				continue;
			}
			if(pos==7||pos==22||pos==36){
				ch = (ch+1)%16;
				switch(ch){
				case 0: pos=0;break;
				case 1: pos=11;break;
				case 2: pos=24;break;
				case 3: pos=39;break;
				case 4: pos=5;break;
				case 5: pos=nextR(pos);break;
				case 6: pos=nextR(pos);break;
				case 7: pos=nextU(pos);break;
				case 8: pos-=3;break;
				}
				freq[pos]++;
				continue;
			}
			freq[pos]++;
		}
		for(int i=0;i<40;i++){
			System.out.println(i + ":\t" +freq[i]*100/times);
		}
	}
	static int nextR(int pos){
		if(pos==7)
			return 15;
		if(pos==22)
			return 25;
		if(pos==36)
			return 5;
		else
			return -1;
	}
	static int nextU(int pos){
		if(pos==7)
			return 12;
		if(pos==22)
			return 28;
		if(pos==36)
			return 12;
		else
			return -1;
	}
}
