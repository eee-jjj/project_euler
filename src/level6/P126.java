package level6;

import java.util.*;

public class P126 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cap = 20000;
		int target = 1000;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ArrayList<Integer> candidate = new ArrayList<Integer>();
		for(int x=1;x<cap;x++){
			for(int y=1;y<=x;y++){
				if(x*y*2>cap)
					break;
				for(int z=1;z<=y;z++){
					if((x*y+y*z+x*z)*2>cap)
						break;
					
					ArrayList<Integer> weidu = new ArrayList<Integer>();
					for(int i=0;;i++){
						int center = x*y;
						int sides = (x*i + y*i)*2;
						int corner = (i-1)*i/2*4;
						weidu.add(center+sides+corner);
						if(center+sides+corner>cap)
							break;
					}
					int tmp = 0;
					for(int i=0;i<weidu.size()-1;i++){
						int cnt = 0;
						for(int j=0;j<=i;j++){
							cnt += weidu.get(j)*2;
						}
						cnt += (weidu.get(i+1)-x*y)*z;
						cnt -= tmp;
						tmp = cnt+tmp;
						if(cnt>cap)
							break;
						if(map.containsKey(cnt)){
							map.put(cnt, map.get(cnt)+1);
							if(map.get(cnt)==target){
								candidate.add(cnt);
							}
						}
						else{
							map.put(cnt, 1);
						}
					}
				}
			}
		}
		Collections.sort(candidate);
		for(Integer c:candidate){
			if(map.get(c)==target){
				System.out.print("~~~~~~~~~~~~~~~~~~");
				System.out.println(c+":, "+map.get(c));
			}			
		}
		//System.out.println(map);
	}

}
