package level2;

public class P31 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] val = {1,2,5,10,20,50,100,200};
		int cnt = 0;
		for(int a=0;a<=200;a++){
			for(int b=0;b<=100;b++){
				for(int c=0;c<=40;c++){
					for(int d=0;d<=20;d++){
						for(int e=0;e<=10;e++){
							for(int f=0;f<=4;f++){
								for(int g=0;g<=2;g++){
									for(int h=0;h<=1;h++){
										if(val[0]*a+val[1]*b+val[2]*c+val[3]*d+val[4]*e+val[5]*f+val[6]*g+val[7]*h == 200)
											cnt++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
