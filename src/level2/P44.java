package level2;
import java.util.*;
public class P44 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> pen = new ArrayList<Integer>();
		for(int i=1;i<4000;i++){
			int p = i*(3*i-1)/2;
			pen.add(p);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<pen.size();i++){
			for(int j=i+1;j<pen.size();j++){
				int p1 = pen.get(i);
				int p2 = pen.get(j);
				if(p2-p1>min)
					break;
				if(pen.contains(p1+p2) && pen.contains(p2-p1)){
					if(p2-p1<min)
						min = p2-p1;
				}
			}
		}
		System.out.println(min);
	}

}
