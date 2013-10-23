package levelunknown;

import java.util.Random;

public class P205 {
    static int[] cnt9 = new int[40];
    static int[] cnt6 = new int[40];
    static int c9 = 0;
    static int c6 = 0;
    /**
     * @param args
     */
    public static void main(String[] args) {
        go9(0,0);
        go6(0,0);
        double[] p9 = new double[40];
        double[] p6 = new double[40];
        for(int i=0;i<cnt9.length;i++){
            p9[i] = cnt9[i]*1.0/c9;
            p6[i] = cnt6[i]*1.0/c6;
        }
        double res = 0;
        for(int i=1;i<p9.length;i++){
            for(int j=0;j<i;j++){
                res += p9[i]*p6[j];
            }
        }
        System.out.println(res);
    }
    static void go9(int cur, int sum){
        if(cur==9){
            cnt9[sum]++;
            c9++;
            return;
        }
        for(int i=1;i<=4;i++){
            go9(cur+1, sum+i);
        }
    }
    static void go6(int cur, int sum){
        if(cur==6){
            cnt6[sum]++;
            c6++;
            return;
        }
        for(int i=1;i<=6;i++){
            go6(cur+1, sum+i);
        }
    }
}
