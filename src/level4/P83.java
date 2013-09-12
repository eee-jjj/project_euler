package level4;

import java.io.*;
import java.util.*;

/**
 * @author ytao
 *
 */
public class P83 {
	
	static ArrayList<Node> queue = new ArrayList<Node>();
	static int N = 80;
	static int[][] m;
	static boolean[][] vis;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("matrix.txt"));
		
		m = new int[N][N];
		for(int i=0;i<N;i++){
			String line = br.readLine();
			String[] ss = line.split(",");
			for(int j=0;j<N;j++){
				m[i][j] = Integer.parseInt(ss[j]);
			}
		}
		br.close();
		
		vis = new boolean[N][N];
		int[][] d = new int[N][N];
		
		queue.add(new Node(0,0,m[0][0]));
		while(true){
			Collections.sort(queue);
			Node min = queue.remove(0);
			int x = min.x;
			int y = min.y;
			d[x][y] = min.val;
			vis[x][y] = true;
			
			if(x==N-1 && y==N-1){
				System.out.println(min.val);
				System.exit(0);
			}
			
			update(x-1,y,min.val);
			update(x+1,y,min.val);
			update(x,y-1,min.val);
			update(x,y+1,min.val);
		}
	}
	public static void update(int x,int y,int val){
		if(x<0 || x>=N || y<0 || y>=N)
			return;
		if(vis[x][y]==true)
			return;
		Node n = new Node(x,y);
		if(!queue.contains(n)){
			n.val = val+m[x][y];
			queue.add(n);
		}
		else{
			for(Node nn : queue){
				if(nn.x==n.x && nn.y==n.y){
					nn.val = Math.min(nn.val, val + m[x][y]);
				}
			}
		}
	}
}
class Node implements Comparable<Node>{
	int x;
	int y;
	int val;
	public Node(int xx, int yy){
		x = xx;
		y = yy;
	}
	public Node(int xx, int yy, int vval){
		this(xx,yy);
		val = vval;
	}
	@Override
	public boolean equals(Object o){
		Node oo = (Node)o;
		return x==oo.x && y==oo.y;
	}
	@Override
	public int hashCode(){
		return x*y;
	}
	@Override
	public int compareTo(Node o) {
		return val-o.val;
	}
	@Override
	public String toString(){
		return "("+ x + "," + y + "," + val +")";
	}
}