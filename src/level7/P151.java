package level7;

import java.util.ArrayList;
import java.util.Arrays;

public class P151 {
	static double counter = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> init = new ArrayList<Integer>();
		init.add(2);
		init.add(3);
		init.add(4);
		init.add(5);
		go(1, init);
		System.out.println(counter);
	}
	static void go(double curp, ArrayList<Integer> env){
		//System.out.println(curp + ": " + env);
		if(env.size()==1 && env.get(0)!=5){
			//System.out.println(curp + ": " + env);
			counter+=curp;
		}
		int[] cnt = new int[6];
		for(int i=0;i<env.size();i++){
			cnt[env.get(i)]++;
		}
		for(int i=2;i<5;i++){
			if(cnt[i]>0){
				ArrayList<Integer> envcp = new ArrayList<Integer>(env);
				envcp.remove(new Integer(i));
				for(int j=i+1;j<=5;j++){
					envcp.add(j);
				}
				go(curp * cnt[i] / env.size(), envcp);
			}
		}
		if(cnt[5]>0){
			ArrayList<Integer> envcp = new ArrayList<Integer>(env);
			envcp.remove(new Integer(5));
			go(curp * cnt[5] / env.size(), envcp);
		}
	}
}
