package level7;

import java.util.ArrayList;
import java.util.HashSet;

public class P160 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        long cap = 10000;
    	long p = 1;
        long cnt2 = 0;
        long cnt5 = 0;
        long test = 1;
        for (long i = 1; i <= cap ; i++) {
//        	if(i % 100000000 == 0){
//        		System.out.println(i);
//        	}
//        	test *= i;
//        	while(test%10==0){
//        		test/=10;
//        	}
//        	test %= 100000;
        	
            long ii=i;
            if(ii%10==0){
                while(ii%10==0){
                    ii/=10;
                }
            }
            if (ii % 2 == 0) {
                int cnt = 0;
                while (ii % 2 == 0) {
                    cnt++;
                    ii/=2;
                }
                cnt2 += cnt;
            }            
            if (ii % 5 == 0) {
                int cnt = 0;
                while (ii % 5 == 0) {
                    cnt++;
                    ii/=5;
                }
                cnt5 += cnt;
            }
            if(ii%2!=0 && ii%5!=0){
                p*=ii;
            }
            p %= 100000;
            //System.out.println(i + ": " + p);
        }
        for(long i=0;i<cnt2-cnt5;i++){
            p *= 2;
            p %= 100000;
        }
   
        System.out.println("test: "+test);
        System.out.println("my  : "+p);        
    }
    
}
