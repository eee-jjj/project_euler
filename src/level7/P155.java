package level7;

import java.util.HashSet;
import java.util.TreeSet;

public class P155 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int len = 8;
        TreeSet<Fraction>[] f = new TreeSet[19];
        
        for (int i = 0; i < f.length; i++) {
            f[i] = new TreeSet<Fraction>();
        }
        
        f[1].add(new Fraction(1,1));
        
        for (int i = 2; i < f.length; i++) {
            System.out.println(i);
            for (int p1 = 1; p1 <= i / 2; p1++) {
                int p2 = i - p1;
                TreeSet<Fraction> possible1 = f[p1];
                TreeSet<Fraction> possible2 = f[p2];
                for (Fraction d1 : possible1) {
                    for (Fraction d2 : possible2) {
                        int x = d1.x*d2.y + d1.y*d2.x;
                        int y = d1.y * d2.y;
                        Fraction pos1 = new Fraction(x, y);
                        int z = d1.x * d2.x;
                        Fraction pos2 = new Fraction(z, x);
                        f[i].add(pos2);
                        f[i].add(pos1);
                    }
                }
            }
            System.out.println(f[i].size());
        }
        
        TreeSet<Fraction> finalSet = new TreeSet<Fraction>();
        for (int i = 0; i < f.length; i++) {
            finalSet.addAll(f[i]);
            System.out.println(i + ": " + finalSet.size());
            //System.out.println(finalSet);
        }
    }
}
class Fraction implements Comparable<Fraction>{
    int x;
    int y;
    public Fraction(int xx, int yy){
        int gcd = gcd(xx, yy);
        x=xx/gcd;
        y=yy/gcd;
    }
    public int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
    @Override
    public boolean equals(Object o){
        Fraction f = (Fraction)o;
        if(x*f.y == f.x*y)
            return true;
        else
            return false;
    }
    @Override
    public int compareTo(Fraction f) {
        return x*f.y - y*f.x;
    }
    @Override
    public String toString(){
        return x +"/"+ y;
    }
}
