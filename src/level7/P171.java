package level7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class P171 {
    
    static HashSet<Integer> perfectSquareSet;
    static ArrayList<Integer> perfectSquare = new ArrayList<Integer>();;
    static HashSet<ArrayList<Integer>> sols = new HashSet<ArrayList<Integer>>();
    static HashMap<ArrayList<Integer>, Long> mem = new HashMap<ArrayList<Integer>, Long>();
    static long factorial19;
    
    public static void main(String[] args) {
        factorial19 = factorial(19);
        int upper_limit = 20 * 9 * 9 + 1;
        int i = 1;
        while (i * i < upper_limit) {
            perfectSquare.add(i * i);
            i++;
        }
        perfectSquareSet = new HashSet<Integer>(perfectSquare);
        
        System.out.println(perfectSquare);
        findComb(0, new ArrayList<Integer>(), 0, 0, 20);
        System.out.println(sols.size());
        
        long res = 0;
        for(ArrayList<Integer> sol : sols){
            res += solve(sol);
            res = res % 1000000000;
        }
        
        System.out.println(res);
    }
    
    public static void findComb(int sum, ArrayList<Integer> cur, int curSize, int curNum, int limit) {
        if (curSize > limit || curNum > 9) {
            return;
        }
        if (curSize == limit && perfectSquareSet.contains(sum)) {
            sols.add(cur);
        }
        if (curSize < limit) {
            ArrayList<Integer> cp1 = new ArrayList<Integer>(cur);
            cp1.add(curNum);
            findComb(sum + curNum * curNum, cp1, cp1.size(), curNum, limit);
            
            ArrayList<Integer> cp2 = new ArrayList<Integer>(cur);
            findComb(sum, cp2, curSize, curNum + 1, limit);
        }
    }
    
    public static long solve(ArrayList<Integer> sol){
        HashMap<Integer, Integer> sig = new HashMap<Integer, Integer>();
        long ret = 0;
        for(Integer i : sol){
            if(!sig.containsKey(i)){
                sig.put(i, 0);
            }
            sig.put(i, sig.get(i)+1);
        }
        for(Integer val : sig.keySet()){
            HashMap<Integer, Integer> sigcp = new HashMap<Integer, Integer>(sig);
            sigcp.put(val, sigcp.get(val)-1);
            ArrayList<Integer> freqs = new ArrayList<Integer>(sigcp.values());
            Collections.sort(freqs);
            long c = findC(freqs) % 1000000000;
            ret += val * 111111111 * c;
        }
        return ret;
    }
    
    public static long findC(ArrayList<Integer> freqs){
        if(mem.containsKey(freqs)){
            return mem.get(freqs);
        }
        long ret = factorial19;
        
        for(Integer freq : freqs){
            ret = ret/factorial(freq);
        }
        
        mem.put(freqs, ret);
        return ret;
    }
    
    public static long factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
}
