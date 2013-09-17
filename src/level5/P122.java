package level5;

import java.util.*;
import java.util.Map.Entry;

public class P122 {
	static int cap = 200;
	static int hmax = 15;
	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1, 0, new ArrayList<Node>());
		grow(root);
		
		int[] res = new int[map.size()+1];
		for(Entry<Integer,Integer> e:map.entrySet())
			res[e.getKey()]=e.getValue();
		int sum = 0;
		for(int i=0;i<res.length;i++){
			sum+=res[i];
			System.out.println(i+": "+res[i]);
		}
		System.out.println(sum);
	}
	static void grow(Node node){
		if(node.val>cap)
			return;
		if(node.height>=hmax)
			return;
		if(map.containsKey(node.val) && node.height>map.get(node.val))
			return;
		map.put(node.val, node.height);
		
		Node n2 = new Node(node.val*2, node.height+1);
		ArrayList<Node> parents2 = new ArrayList<Node>(node.parents);
		parents2.add(node);
		n2.parents = parents2;
		node.children.add(n2);
		
		for(Node p : node.parents){
			Node n1 = new Node(node.val+p.val, node.height+1);
			ArrayList<Node> parents1 = new ArrayList<Node>(node.parents);
			parents1.add(node);
			n1.parents = parents1;
			node.children.add(n1);
		}
		
		for(Node nn:node.children)
			grow(nn);
	}
}
class Node{
	int val;
	int height;
	ArrayList<Node> children = new ArrayList<Node>();
	ArrayList<Node> parents = new ArrayList<Node>();
	public Node(int v, int height){
		val = v;
		this.height = height;
	}
	public Node(int v, int height, ArrayList<Node> ps){
		this(v, height);
		parents = ps;
	}
	@Override
	public String toString(){
		return "("+val+","+height+")";
	}
}