package level2;

public class P33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=10;i<99;i++){
			for(int j=i+1;j<99;j++){
				double v1 = (double)i/j;
				
				int i1 = i%10;
				int i2 = i/10;
				int j1 = j%10;
				int j2 = j/10;
				
				double v2 = 0;
				if(i1==j1 || i1==j2 || i2==j1 || i2==j2){
					if(i1==j2){
						v2 = (double)i2/j1;
					}
					if(i2==j1){
						v2 = (double)i1/j2;
					}
				}
				
				if(v1 == v2){
					System.out.println(i + " / " + j);
				}
			}
		}
	}

}
