package level3;

import java.io.*;
import java.util.*;

public class P54 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("poker.txt"));
		String line = "";
		int cnt = 0;
		while((line=br.readLine()) != null){
			String[] ss = line.split(" ");
			String[] p1 = new String[5];
			String[] p2 = new String[5];
			for(int i=0;i<10;i++){
				if(i<5)
					p1[i] = ss[i];
				else
					p2[i-5] = ss[i];
			}
			Card c1 = pre(p1);
			Card c2 = pre(p2);
			
			if(comp(c1,c2)>0){
				cnt++;
				//if(c1.rank==c2.rank)
					//System.out.println(line + "\t" + c1.rank +"\t"+ c2.rank + "\tP1 win");
			}
			else{
				if(c1.rank==c2.rank)
					System.out.println(line + "\t" + c1.rank +"\t"+ c2.rank + "\tP2 win");
			}
				
		}
		System.out.println(cnt);
	}
	public static int comp(Card c1, Card c2){
		if(c1.rank!=c2.rank)
			return c1.rank-c2.rank;
		else{
			int x = 0;
			while(true){
				if(c1.hval.get(x)!=c2.hval.get(x))
					return c1.hval.get(x)-c2.hval.get(x);
				else
					x++;
			}
		}
	}
	public static Card pre(String[] cards){
		int[] num = new int[5];
		int[] suit = new int[5];
		for(int i=0;i<5;i++){
			char x = cards[i].charAt(0);
			char y = cards[i].charAt(1);
			
			switch(y){
			case 'H': suit[i] = 1;break;
			case 'D': suit[i] = 2;break;
			case 'C': suit[i] = 3;break;
			case 'S': suit[i] = 4;break;
			}				
			if(x>='2' && x<='9'){
				num[i] = x-'0';
			}
			else{
				switch(x){
				case 'T': num[i]=10;break;
				case 'J': num[i]=11;break;
				case 'Q': num[i]=12;break;
				case 'K': num[i]=13;break;
				case 'A': num[i]=14;break;
				}
			}
		}
		return new Card(num, suit);
	}
	
}
class Card{
	int[] num;
	int[] suits;
	int rank;
	ArrayList<Integer> hval;
	public Card(int[] numm, int[] suitss){
		num = numm;
		suits = suitss;
		hval = new ArrayList<Integer>();
		
		init();
	}
	public void init(){
		if(is10(num,suits)){
			return;
		}
		if(is9(num,suits)){
			return;
		}
		if(is8(num)){
			return;
		}
		if(is7(num)){
			return;
		}
		if(is6(num,suits)){
			return;
		}
		if(is5(num)){
			return;
		}
		if(is4(num)){
			return;
		}
		if(is3(num)){
			return;
		}
		if(is2(num)){
			return;
		}
		if(is1(num)){
			return;
		}
	}
	public boolean is10(int[] num, int[] suit){
		Arrays.sort(num);
		Arrays.sort(suit);
		
		boolean straight = false;
		boolean flush = false;
		if(num[0]==10 && num[1]==11 && num[2]==12 && num[3]==13 && num[4]==14)
			straight = true;
		if(suit[0]==suit[1] && suit[1]==suit[2] && suit[2]==suit[3] && suit[3]==suit[4])
			flush = true;
		if(straight && flush){
			rank = 10;
			hval.add(num[4]);
		}
		
		return straight && flush;
	}
	public boolean is9(int[] num, int[] suit){
		Arrays.sort(num);
		Arrays.sort(suit);
		
		boolean straight = false;
		boolean flush = false;
		if(num[1]==num[0]+1 && num[2]==num[0]+2 && num[3]==num[0]+3 && num[4]==num[0]+4)
			straight = true;
		if(suit[0]==suit[1] && suit[1]==suit[2] && suit[2]==suit[3] && suit[3]==suit[4])
			flush = true;
		if(straight && flush){
			rank = 9;
			hval.add(num[4]);
		}
		
		return straight && flush;
	}
	public boolean is8(int[] num){
		Arrays.sort(num);
		int[] bf = new int[20];
		for(int n:num){
			bf[n]++;
		}
		for(int n:num){
			if(bf[n]==4){
				rank = 8;
				hval.add(n);
				return true;
			}
		}
		return false;
	}
	public boolean is7(int[] num){
		Arrays.sort(num);
		if(num[1]==num[0] && num[2]==num[3] && num[3]==num[4]){
			rank = 7;
			hval.add(num[4]);
			hval.add(num[0]);
			return true;
		}			
		if(num[1]==num[0] && num[2]==num[0] && num[3]==num[4]){
			rank = 7;
			hval.add(num[0]);
			hval.add(num[4]);
			return true;
		}
		return false;
	}
	public boolean is6(int[] num, int[] suit){
		Arrays.sort(num);
		Arrays.sort(suit);
		if(suit[0]==suit[1] && suit[1]==suit[2] && suit[2]==suit[3] && suit[3]==suit[4]){
			rank = 6;
			hval.add(num[4]);
			return true;
		}
		return false;
	}
	public boolean is5(int[] num){
		Arrays.sort(num);
		if(num[1]==num[0]+1 && num[2]==num[0]+2 && num[3]==num[0]+3 && num[4]==num[0]+4){
			rank = 5;
			hval.add(num[4]);
			return true;
		}
		return false;
	}
	public boolean is4(int[] num){
		Arrays.sort(num);
		int[] bf = new int[20];
		for(int n:num){
			bf[n]++;
		}
		for(int n:num){
			if(bf[n]==3){
				rank = 4;
				hval.add(n);
				return true;
			}
		}
		return false;
	}
	public boolean is3(int[] num){
		Arrays.sort(num);
		int[] bf = new int[20];
		for(int n:num){
			bf[n]++;
		}
		int cnt = 0;
		for(int n=bf.length-1;n>=0;n--){
			if(bf[n]==2){
				cnt++;				
			}
		}
		if(cnt!=2)
			return false;
		rank = 3;
		for(int n=bf.length-1;n>=0;n--){
			if(bf[n]==2){
				hval.add(n);				
			}
		}
		for(int m=bf.length-1;m>=0;m--){
			if(bf[m]>0 && bf[m]!=2)
				hval.add(m);
		}
		return true;
	}
	public boolean is2(int[] num){
		Arrays.sort(num);
		int[] bf = new int[20];
		for(int n:num){
			bf[n]++;
		}
		for(int n:num){
			if(bf[n]==2){
				rank = 2;
				hval.add(n);
				for(int m=bf.length-1;m>=0;m--){
					if(bf[m]>0 && bf[m]!=2)
						hval.add(m);
				}
				return true;
			}
		}
		return false;
	}
	public boolean is1(int[] num){
		rank = 1;
		Arrays.sort(num);
		for(int i=num.length-1;i>=0;i--){
			hval.add(num[i]);
		}
		return true;
	}
}
