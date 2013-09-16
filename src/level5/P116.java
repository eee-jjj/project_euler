package level5;

import java.util.Arrays;

public class P116 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 50;
		
		long dpr[] = new long[len+1];
		dpr[2] = 1;
		for(int i=3;i<dpr.length;i++){
			dpr[i] = dpr[i-1] + dpr[i-2] + 1;
		}
		System.out.println(Arrays.toString(dpr));
		
		long dpg[] = new long[len+1];
		dpg[3] = 1;
		for(int i=4;i<dpg.length;i++){
			dpg[i] = dpg[i-1] + dpg[i-3] + 1;
		}
		System.out.println(Arrays.toString(dpg));
		
		long dpb[] = new long[len+1];
		dpb[4] = 1;
		for(int i=5;i<dpb.length;i++){
			dpb[i] = dpb[i-1] + dpb[i-4] + 1;
		}
		System.out.println(Arrays.toString(dpb));
		
		System.out.println(dpr[len]+dpg[len]+dpb[len]);
	}

}
