package level2;

public class P39 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] cnt = new int[1001];
		
		for(int i=1;i<=400;i++){
			for(int j=i;j<=400;j++){
				for(int k=j;k<=400;k++){
					if(i*i + j*j == k*k){
						cnt[i+j+k]++;
					}
				}
			}
		}
		
		int max = 0;
		int index = -1;
		for(int i=0;i<1001;i++){
			if(cnt[i]>max){
				max = cnt[i];
				index = i;
			}
		}
		System.out.println(max +" "+ index);
	}

}
