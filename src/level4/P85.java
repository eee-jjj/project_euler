package level4;

public class P85 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;
		int ii = -1;
		int jj = -1;
		for(int i=1;i<200;i++){
			for(int j=i;calc(i,j)<2000000;j++){
				int p = calc(i,j);
				if(2000000-p<min){
					min = 2000000-p;
					ii = i;
					jj = j;
				}
			}
		}
		System.out.println(min +": "+ii+", "+jj);
		System.out.println(ii*jj);
	}
	public static int calc(int x, int y){
		return x*y*(x+1)*(y+1)/4;
	}
}
