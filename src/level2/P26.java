package level2;
import java.util.*;

public class P26 {
	
	public static void main(String[] args){
		int max = -1;
		int len = -1;
		for(int i=1;i<1000;i++){
			int recurLen = getRecur(i);
			//System.out.println(recurLen);
			if(recurLen > max){
				max = recurLen;
				len = i;
			}
		}
		System.out.println(max + " " + len);
	}
	
	public static int getRecur(int n){
		ArrayList<Integer> residu = new ArrayList<Integer>();
		
		int x = 1;
		while(x<n){
			x *= 10;
		}
		
		while(true){
			int modd = x%n;
			if(residu.contains(modd)){
				return residu.size()-residu.indexOf(modd);
			}
			else{
				residu.add(modd);
			}
			x = modd * 10;
		}
	}
}
