package level6;

public class P145 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cnt = 0;
		for(int i=1;i<1e9;i++){
			if(i % 1e6 == 0)
				System.out.println(i);
			if(i % 10 ==0)
				continue;
			StringBuilder sb = new StringBuilder(String.valueOf(i));
			sb.reverse();
			int ir = Integer.parseInt(sb.toString());
			int s = i+ir;
			while(s>0){
				if(s%2==1)
					s/=10;
				else
					break;
			}
			if(s==0)
				cnt++;
		}
		System.out.println(cnt);
	}

}
