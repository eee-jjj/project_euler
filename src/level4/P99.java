package level4;

import java.io.*;

public class P99 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("base_exp.txt"));
		int ln = -1;
		int max_b = 10;
		int max_e = 10;
		
		String line = "";
		int x = 1;
		while((line=br.readLine())!=null){
			String[] ls = line.split(",");
			int base = Integer.parseInt(ls[0]);
			int exp = Integer.parseInt(ls[1]);
			
			double c = Math.log(base)/Math.log(max_b);
			if(c*exp > max_e){
				max_b = base;
				max_e = exp;
				ln = x;
			}
			x++;
		}		
		br.close();
		
		System.out.println(ln + "," + max_b +","+ max_e);
	}

}
