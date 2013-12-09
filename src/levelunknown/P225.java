package levelunknown;

import java.util.ArrayList;
import java.util.HashSet;

public class P225 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int cnt = 0;
        for (int o = 3;; o += 2) {
            if(cnt>=124){
                break;
            }
            
            ArrayList<Integer> T = new ArrayList<Integer>();
            T.add(1);
            T.add(1);
            T.add(1);
            
            HashSet<Triple> map = new HashSet<Triple>();
            map.add(new Triple(1, 1, 1));
            
            for (int i = 3;; i++) {
                int t = T.get(i - 1) + T.get(i - 2) + T.get(i - 3);
                t = t % o;
                
                if(t==0){
                    break;
                }
                
                Triple tri = new Triple(T.get(i - 2), T.get(i - 1), t);
                
                if (map.contains(tri)) {
                    cnt++;
                    System.out.println(cnt + ": "+ o);
                    break;
                }
                else {
                    map.add(tri);
                }
                
                //System.out.println(t);
                T.add(t);
            }
        }
        
    }
    
}

class Triple {
    
    int x;
    int y;
    int z;
    
    public Triple(int xx, int yy, int zz) {
        x = xx;
        y = yy;
        z = zz;
    }
    
    public int hashCode() {
        return x * y * z;
    }
    
    public boolean equals(Object o) {
        Triple t = (Triple) o;
        return t.x == x && t.y == y && t.z == z;
    }
}