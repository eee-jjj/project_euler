package level2;
import java.util.*;
import java.io.*;

public class P42 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("words.txt"));
		String line = br.readLine();
		br.close();
		
		HashSet<Integer> tri = new HashSet<Integer>();
		for(int i=0;i<1000;i++){
			int t = i*(i+1)/2;
			tri.add(t);
		}
		
		String[] words = line.split(",");
		int cnt = 0;
		for(String word:words){
			word = word.replaceAll("\"", "");
			int val = 0;
			for(int i=0;i<word.length();i++){
				val += word.charAt(i)-'A'+1;
			}
			
			if(tri.contains(val))
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
