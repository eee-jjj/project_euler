package level3;

public class P53 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 100;
		int[][] c = new int[N+1][N+1];
		for(int i=1;i<N+1;i++){
			c[i][1] = i;
			c[i][i] = 1;
		}
		
		int cnt = 0;
		for(int i=2;i<N+1;i++){
			for(int j=2;j<i;j++){
				if(c[i-1][j-1]==-1 || c[i-1][j]==-1){
					c[i][j]=-1;
					cnt++;
				}
				else{
					c[i][j] = c[i-1][j-1] + c[i-1][j];
				}
				if(c[i][j]>1000000){
					c[i][j]=-1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
