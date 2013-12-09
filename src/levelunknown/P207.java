package levelunknown;

import java.util.ArrayList;


public class P207 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Long> boundry = new ArrayList<Long>();
        for(int t=1;t<1000;t++){
            double a = Math.pow(2, t);
            a = a*(a-1);
            boundry.add((long)a);
        }
        
        int cnt = 0;
        for(long n=1;;n++){
            long k = n*(n+1);
            
            if(k>=boundry.get(cnt)){
                cnt++;
            }
            
            double ratio = cnt*1.0/n;
            if(ratio < 1.0/12345){
                System.out.println(k + ": " + cnt + "/" + n + " " + ratio);
                break;
            }
        }
    }
    
}
