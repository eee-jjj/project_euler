package level8;

import java.util.Arrays;
import java.util.HashSet;


public class P185 {
    
    static int[][] m;
    static int[] ans;
    static int[] correct;
    
    public static void main(String[] args) {
        String[] input = {"5616185650518293",
                "3847439647293047",
                "5855462940810587",
                "9742855507068353",
                "4296849643607543",
                "3174248439465858",
                "4513559094146117",
                "7890971548908067",
                "8157356344118483",
                "2615250744386899",
                "8690095851526254",
                "6375711915077050",
                "6913859173121360",
                "6442889055042768",
                "2321386104303845",
                "2326509471271448",
                "5251583379644322",
                "1748270476758276",
                "4895722652190306",
                "3041631117224635",
                "1841236454324589",
                "2659862637316867"
        };
        correct = new int[]{2,1,3,3,3,1,2,3,1,2,3,1,1,2,0,2,2,3,1,3,3,2};
        m = new int[22][16];
        ans = new int[16];
        Arrays.fill(ans, -1);
        
        for(int i=0;i<input.length;i++){
            for(int j=0;j<16;j++){
                m[i][j] = input[i].charAt(j)-'0';
            }
        }
        
        int[] excl = {2,3,2,1,3,8,6,1,0,4,3,0,3,8,4,5};
        
        solve();
    }
    static void solve(int pos){
        if(pos==16){
            System.out.println(Arrays.toString(ans));
            return;
        }
        
        int c = correct[pos];
        HashSet<Integer> options = new HashSet<Integer>();
        for(int i=0;i<16;i++){
            if(ans[i]<0)
                options.add(i);
            if(ans[i]==m[pos][i]){
                c--;
            }
        }
        if(c<0){
            return;
        }
    }
}
