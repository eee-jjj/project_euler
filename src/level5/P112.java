package level5;

import java.util.*;

public class P112 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int bouncy = 0;
		int nonbouncy = 0;
		int i = 1;
		while(true){
			if(isNonBouncy(i)){
				nonbouncy++;
			}
			else
				bouncy++;
			if(i>=nonbouncy*100){
				System.out.println(i);
				break;
			}			
			i++;
		}
	}
	static boolean isNonBouncy(int n){
		boolean in = true;
		boolean de = true;
		char[] c = String.valueOf(n).toCharArray();
		for(int i=0;i<c.length-1;i++){
			if(c[i]>c[i+1])
				in = false;
			if(c[i]<c[i+1])
				de = false;
		}
		return in || de;
	}
}
