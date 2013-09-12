package level3;

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class P59 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("cipher1.txt"));
		String line = br.readLine();
		br.close();
		
		String[] snums = line.split(",");
		int[] en = new int[snums.length];
		int[] de = new int[snums.length];
		
		for(int i=0;i<snums.length;i++){
			en[i] = Integer.parseInt(snums[i]);
		}
//		int ss = 65^42;
//		ss = ss^42;
		
		i: for(int i=97;i<=122;i++){
			j: for(int j=97;j<=122;j++){
				k: for(int k=97;k<=122;k++){
					for(int x=0;x<en.length;x++){
						int d = -1;
						if(x%3==0)
							d = en[x]^i;
						else if(x%3==1)
							d = en[x]^j;
						else if(x%3==2)
							d = en[x]^k;
						de[x] = d;
						
						if(d<32){
							if(x%3==0)
								continue i;
							else if(x%3==1)
								continue j;
							else if(x%i==2)
								continue k;
						}
					}
					String ss = "";
					for(int x=0;x<en.length;x++){
						ss += (char)(de[x]);
					}
					boolean match = Pattern.matches(".* is .*", ss);
					if(match){
//						System.out.println(i + " " + j + " " + k + " ");
//						System.out.println(ss);
					}
					if(i==103 && j==111 && k==100){
						int sum = 0;
						for(int x=0;x<en.length;x++){
							sum+=de[x];
						}
						System.out.println(ss);
						System.out.println(sum);
					}
				}
			}
		}
	}

}
