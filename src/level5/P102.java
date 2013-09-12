package level5;

import java.io.*;

public class P102 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("triangles.txt"));
		String line = "";
		int cnt = 0;
		while((line=br.readLine())!=null){
			String[] ls = line.split(",");
			int[][] v = new int[3][2];
			for(int i=0;i<3;i++){
				for(int j=0;j<2;j++){
					v[i][j] = Integer.parseInt(ls[i*2+j]);
				}
			}
			boolean flag = true;
			for(int i=0;i<3;i++){
				for(int j=i+1;j<3;j++){
					if(i==j)
						continue;					
					if(v[i][0]!=v[j][0]){
						double slope = (v[j][1]-v[i][1])/(double)(v[j][0]-v[i][0]);
						double b = v[j][1]-slope*v[j][0];
						for(int k=0;k<3;k++){
							if(k!=i && k!=j){
								int sig1 = v[k][1]-slope*v[k][0]-b>0 ? 1 : -1;
								int sig2 = -b>0 ? 1 : -1;
								if(sig1*sig2<0){
									flag = false;
								}
								break;
							}
						}
					}
					else{
						for(int k=0;k<3;k++){
							if(k!=i && k!=j){
								int sig1 = 0-v[i][0]>0 ? 1 : -1;
								int sig2 = v[k][0]-v[i][0]>0 ? 1 : -1;
								if(sig1*sig2<0){
									flag = false;
								}
								break;
							}
						}
					}
				}
			}
			if(flag){
				cnt++;
			}
		}
		br.close();
		System.out.println(cnt);
	}
}
