package level8;

import java.util.LinkedList;

public class P186 {
    static LinkedList<Long> S = new LinkedList<Long>();
    
    public static void main(String[] args) {
        DJSet djset = new DJSet();
        
        int pm = 524287;
        long n = 1;
        int misdial = 0;
        while(true){
            int caller = (int)gen(2*n-1);
            int called = (int)gen(2*n);
            if(caller == called){
            	continue;
            }
            
            djset.union(caller, called);
            
            int root = djset.find(pm);
            int friends = djset.size[root];
            
            if(friends >= 990000){
            	System.out.println(n + ", " + misdial);
            	break;
            }
            
            n++;
        }
        
    }
    
    static long gen(long k){
        if(k<=55){
            long sk = (int)((100003L - 200003L*k + 300007L*k*k*k) % 1000000);
            S.add(sk);
            return sk;
        } else {
        	long s1 = S.get(0);
        	long s2 = S.get(31);
            long sk = (s1+s2) % 1000000;
            S.add(sk);
            S.remove(0);
            
            return sk;
        }
    }
}
class DJSet{
    int[] parent;
    int[] rank;
    int[] size;
    public DJSet(){
        parent = new int[1000001];
        rank = new int[1000001];
        size = new int[1000001];
        
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int i){
        if(parent[i]==i){
            return i;
        } else {
            int res = find(parent[i]);
            parent[i] = res;
            return res;
        }
    }
    public void union(int i, int j){
        int iroot = find(i);
        int jroot = find(j);
        
        if(iroot == jroot)
        	return;
        
        int irank = rank[iroot];
        int jrank = rank[jroot];
        if(irank<jrank){
        	parent[iroot] = jroot;
        	size[jroot] += size[iroot];
        } else if(irank>jrank){
        	parent[jroot] = iroot;
        	size[iroot] += size[jroot];
        } else {
        	parent[jroot] = iroot;
        	rank[iroot] += 1;
        	size[iroot] += size[jroot];
        }
    }
}