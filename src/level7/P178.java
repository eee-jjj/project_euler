package level7;

public class P178 {
    
    static int cap = 40;
    static int cnt = 0;
    
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            //test(String.valueOf(i));
        }
        System.out.println(cnt);
        
        solve();
    }
    
    static void solve() {
        long[][][][] dp = new long[cap + 1][10][10][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i][i][i] = 1;
        }
        for (int i = 1; i < cap; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = k; l < 10; l++) {
                        if (j > 0) {
                            dp[i + 1][j - 1][Math.min(j - 1, k)][l] += dp[i][j][k][l];
                        }
                        if (j < 9) {
                            dp[i + 1][j + 1][k][Math.max(j + 1, l)] += dp[i][j][k][l];
                        }
                    }
                }
            }
        }
        long res = 0;
        for (int i = 1; i < cap + 1; i++) {
            for (int j = 0; j < 10; j++) {
                res += dp[i][j][0][9];
            }
        }
        System.out.println(res);
    }
    
    static void test(String str) {
        if (str.length() == cap) {
            if (pan(str) == 10) {
                System.out.println(str);
                cnt++;
            }
            return;
        }
        int d = str.charAt(str.length() - 1) - '0';
        if (d > 0) {
            test(str + (d - 1));
        }
        if (d < 9) {
            test(str + (d + 1));
        }
    }
    
    static int pan(String x) {
        int res = 0;
        int[] cnt = new int[10];
        for (int i = 0; i < x.length(); i++) {
            cnt[x.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0)
                res++;
        }
        return res;
    }
}
