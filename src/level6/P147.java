package level6;


public class P147 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int x = 47;
        int y = 43;
        long res = 0;
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                res += type1(i,j)+type2(i,j);
            }
        }
        System.out.println(res);
    }
    
    static long type1(int x, int y){
        long sum = 0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                sum += (x-i) * (y-j);
            }
        }
        return sum;
    }
    
    static long type2(int x, int y){
        long sum = 0;
        int xx = 2*x;
        int yy = 2*y;
        for(int i=0;i<xx;i++){
            for(int j=0;j<yy;j++){
                if((i+j)%2!=0){
                    continue;
                }
                for(int len1 = 1;i+len1<=xx && j+len1<=yy;len1++){
                    int len2 = 1;
                    for(;i-len2>=0 && j+len2+len1<=yy;len2++){
                        ;
                    }
                    sum += len2-1;
                }
            }
        }
        return sum;
    }
}
