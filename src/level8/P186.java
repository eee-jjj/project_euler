package level8;

import java.util.ArrayList;


public class P186 {
    static ArrayList<Long> S = new ArrayList<Long>();
    
    public static void main(String[] args) {
        
        DJSet djset = new DJSet();
        
        int pm = 524287;
        int n = 1;
        while(true){
            int caller = (int)gen(2*n-1);
            int called = (int)gen(2*n);
            
            djset.union(caller, called);
            
            int root = djset.find(pm);
            
            n++;
        }
    }
    
    static long gen(int k){
        if(k<=55){
            long sk = (100003L - 200003L*k + 300007L*k*k*k) % 1000000;
            S.add(sk);
            return S.get(k);
        } else {
            long sk = (S.get(k-24) + S.get(k-55)) % 1000000;
            S.add(sk);
            return sk;
        }
    }
}
class DJSet{
    ArrayList<Integer> parent;
    ArrayList<Integer> rank;
    public DJSet(){
        parent = new ArrayList<Integer>(1000001);
        for(int i=0;i<parent.size();i++){
            parent.set(i, i);
        }
    }
    
    public int find(int i){
        if(parent.get(i)==i){
            return i;
        } else {
            int res = find(parent.get(i));
            parent.set(i, res);
            return res;
        }
    }
    public void union(int i, int j){
        int iroot = find(i);
        int jroot = find(j);
        parent.set(iroot, jroot);
    }
}