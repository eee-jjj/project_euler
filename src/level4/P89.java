package level4;

import java.io.*;
import java.util.*;

public class P89 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String[][] t = {{"", "I","II","III","IV","V","VI","VII","VIII","IX"},
						{"", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
						{"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
						{"", "M","MM","MMM","MMMM"," ","  ","   ","    ","  "},
						{"", "", "","","","","","","",""}};
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		HashSet<String> set = new HashSet<String>();
		
		for(int i=1;i<5000;i++){
			String ii = String.valueOf(i);
			int len = ii.length();
			String val = "";
			for(int j=0;j<len;j++){
				int d = Integer.parseInt(ii.substring(j,j+1));
				val += t[len-1-j][d];
			}
			map.put(i, val);
			set.add(val);
		}
		
		BufferedReader br = new BufferedReader(new FileReader("roman.txt"));
		String line = "";
		int cnt = 0;
		while((line=br.readLine())!=null){
			line = line.trim();
			int x = i2r(line);
			cnt += line.length()-map.get(x).length();
		}
		br.close();
		System.out.println(cnt);
	}
	public static int i2r(String n){
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		m.put("I", 1);
		m.put("V", 5);
		m.put("X", 10);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);
		
		int sum = 0;
		for(int i=0;i<n.length()-1;i++){
			int a = m.get(n.substring(i, i+1));
			int b = m.get(n.substring(i+1, i+2));
			if(a<b){
				sum -= a;
			}
			else{
				sum += a;
			}				
		}
		sum += m.get(n.substring(n.length()-1));
		return sum;
	}
}
