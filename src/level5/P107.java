package level5;

import java.util.*;
import java.io.*;

public class P107 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("network.txt"));
		int N = 40;
		int[][] g = new int[N][N];
		int total = 0;
		for(int i=0;i<N;i++){
			String line = br.readLine();
			String[] ls = line.split(",");
			for(int j=0;j<N;j++){
				if(ls[j].equals("-"))
					g[i][j] = Integer.MAX_VALUE;
				else{
					g[i][j] = Integer.parseInt(ls[j]);
					total += g[i][j];
				}
			}
		}
		br.close();
		
		PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
		boolean[] vis = new boolean[N];
		vis[0] = true;
		for(int i=1;i<N;i++){
			heap.add(new Edge(0,i,g[0][i]));
		}
		int visited = 1;
		int sum = 0;
		while(true){
			Edge e = heap.remove();
			if(vis[e.des]==false){
				vis[e.des]=true;
				visited++;
				sum += e.val;
				for(int i=0;i<N;i++){
					if(vis[i]==false)
						heap.add(new Edge(e.des, i, g[e.des][i]));
				}
				if(visited==N)
					break;
			}
		}
		System.out.println(total/2-sum);
	}

}
class Edge implements Comparable<Edge>{
	int src;
	int des;
	int val;
	public Edge(int x,int y,int z){
		src = x;
		des = y;
		val = z;
	}
	@Override
	public int compareTo(Edge o) {
		return val-o.val;
	}
	@Override
	public String toString(){
		return "("+src+","+des+","+val+")";
	}
}
