package level4;

import java.util.*;
import java.io.*;

public class P96 {
	static int[][] std = new int[9][9];
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("sudoku.txt"));
		String line = "";
		
		int sum = 0;
		for(int z=0;z<50;z++){
			line = br.readLine();
			int[][] su = new int[9][9];
			for(int y=0;y<9;y++){
				line = br.readLine();
				for(int i = 0;i<9;i++)
					su[y][i] = line.charAt(i)-'0';
			}
			
			fill(su);
			int var = std[0][0]*100 + std[0][1]*10 + std[0][2];
			sum += var;
		}
		System.out.println(sum);
		br.close();
	}
	static void fill(int[][] su){
		_fill(0,0,su);
	}
	static void _fill(int x, int y, int[][] su){
		if(x==9){
			std = su;
			return;
		}
		else if(y==9)
			_fill(x+1,0,su);
		else if(su[x][y]!=0)
			_fill(x,y+1,su);
		else{
			for(int i=1;i<=9;i++){
				int[][] sucp = new int[9][9];
				for(int z=0;z<9;z++)
					sucp[z] = Arrays.copyOf(su[z], 9);
				sucp[x][y] = i;
				if(check(x,y,sucp))
					_fill(x, y+1, sucp);
			}
		}
	}
	static boolean check(int x, int y, int[][] su){
		// row
		for(int i=0;i<9;i++){
			if(su[x][i]==su[x][y] && i!=y)
				return false;
		}
		// column
		for(int i=0;i<9;i++){
			if(su[i][y]==su[x][y] && x!=i)
				return false;
		}
		// block
		int xx = x/3;
		int yy = y/3;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(su[xx*3+i][yy*3+j]==su[x][y] && !(xx*3+i==x && yy*3+j==y))
					return false;
			}
		}
		return true;
	}
}
