package level6;

import java.util.Arrays;


public class P148 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        long line = (long)1e9;
        
        long[] unit = new long[12];
        
        unit[0] = 1;
        unit[1] = (1+7)*7/2;
        for(int i=2;i<unit.length;i++){
            unit[i] = (1+7)*7/2*unit[i-1];
        }
        System.out.println(Arrays.toString(unit));
        
        int pow = (int)(Math.log(line)/Math.log(7));
        
        long sum = 0;
        long m = 1;
        while(true){
            long n7 = (long)Math.pow(7, pow);
            long num = line/n7;
            sum += ((1+num)*num/2)*unit[pow]*m;
            
            line = line % n7;
            m *= (num+1);
            
            if(line<7){
                break;
            }
            pow--;
        }
        System.out.println(sum);
        for(int i=1;i<=line;i++){
            sum += m*i;
        }
        System.out.println(sum);
    }
    
}
