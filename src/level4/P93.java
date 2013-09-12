package level4;

import java.util.*;

public class P93 {
	static boolean[] score = new boolean[10000];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		for(int i=1;i<=6;i++){
			for(int j=i+1;j<=7;j++){
				for(int k=j+1;k<=8;k++){
					for(int l=k+1;l<=9;l++){
						Arrays.fill(score,false);
						ArrayList<double[]> set = genSet(i,j,k,l);
						for(double[] perm:set){
							cal(perm);
						}
						for(int z=1;z<score.length;z++){
							if(score[z]==false){
								System.out.println(i+","+j+","+k+","+l+": "+(z-1));
								if(z-1>max)
									max=z-1;
								break;
							}
						}						
						
					}
				}
			}
		}
		System.out.println(max);
	}
	static void cal(double[] in){
		if(in.length==1){
			if((int)in[0]==in[0] && in[0]>0)
				score[(int)in[0]]=true;
			return;
		}
		for(int i=0;i<in.length-1;i++){
			double[] x = new double[4];
			x[0] = in[i]+in[i+1];
			x[1] = in[i]-in[i+1];
			x[2] = in[i]*in[i+1];
			x[3] = in[i]/in[i+1];
			
			for (int k = 0; k < 4; k++) {
				double[] newin = new double[in.length - 1];
				for (int j = 0; j < i; j++)
					newin[j] = in[j];
				for (int j = i + 1; j < in.length - 1; j++) 
					newin[j] = in[j + 1];
				newin[i] = x[k];
				cal(newin);
			}
		}
	}
	static ArrayList<double[]> genSet(double a,double b,double c,double d){
		ArrayList<double[]> set = new ArrayList<double[]>();
		double[] list1 = {a,b,c,d};
		double[] list2 = {a,b,d,c};
		double[] list3 = {a,c,b,d};
		double[] list4 = {a,c,d,b};
		double[] list5 = {a,d,b,c};
		double[] list6 = {a,d,c,b};
		double[] list7 = {b,a,c,d};
		double[] list8 = {b,a,d,c};
		double[] list9 = {b,c,a,d};
		double[] list10 = {b,c,d,a};
		double[] list11 = {b,d,a,c};
		double[] list12 = {b,d,c,a};
		double[] list13 = {c,a,b,d};
		double[] list14 = {c,a,d,b};
		double[] list15 = {c,b,a,d};
		double[] list16 = {c,b,d,a};
		double[] list17 = {c,d,a,b};
		double[] list18 = {c,d,b,a};
		double[] list19 = {d,a,b,c};
		double[] list20 = {d,a,c,b};
		double[] list21 = {d,b,a,c};
		double[] list22 = {d,b,c,a};
		double[] list23 = {d,c,a,b};
		double[] list24 = {d,c,b,a};
		set.add(list1);
		set.add(list2);
		set.add(list3);
		set.add(list4);
		set.add(list5);
		set.add(list6);
		set.add(list7);
		set.add(list8);
		set.add(list9);
		set.add(list10);
		set.add(list11);
		set.add(list12);
		set.add(list13);
		set.add(list14);
		set.add(list15);
		set.add(list16);
		set.add(list17);
		set.add(list18);
		set.add(list19);
		set.add(list20);
		set.add(list21);
		set.add(list22);
		set.add(list23);
		set.add(list24);
		return set;		
	}
}