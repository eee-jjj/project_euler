package level7;

import java.util.ArrayList;

public class P152 {
    static int cnt = 0;
    static double[] sum;
    static int stop = 45;
    static double e = 1e-8;
    static int[] num = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 18, 20, 21, 24, 28, 30, 35, 36, 39, 40, 42, 45, 52, 56, 60, 63, 70, 72};
    
    public static void main(String[] args) {
        solve(new ArrayList<Integer>(), 0.0, 0);
        System.out.println(cnt);
    }
    
    static void solve(ArrayList<Integer> cur, double x, int pos) {
        if (x == 0) {
            x = 1.0 / 4;
            cur.add(0);
            solve(cur, x, pos + 1);
            return;
        }
        if (x > 0.51) {
            //System.out.println("2:"+cur + ": " + x);
            return;
        }
        if (pos>=num.length){
            return;
        }
        
        ArrayList<Integer> cp = new ArrayList<Integer>(cur);
        cp.add(pos);
        double y = x + 1.0 / (num[pos] * num[pos]);
        if (Math.abs(y - 0.5) < e) {
            for(int i=0;i<cp.size();i++){
                System.out.print(num[cp.get(i)]+",");
            }
            System.out.print("\n");
            cnt++;
        }
        solve(cp, y, pos + 1);
        
        solve(cur, x, pos + 1);
    }
}
