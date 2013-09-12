package level3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author ytao
 *
 */
public class P68 {
	public static void main(String[] args){
		ArrayList<String> r = new ArrayList<String>();
		for(int x1=1;x1<=9;x1++){
			for(int x2=1;x2<=9;x2++){
				if(x1==x2) continue;
				for(int x3=1;x3<=9;x3++){
					if(x3==x2 || x3==x1) continue;
					for(int x4=1;x4<=9;x4++){
						if(x4==x3 || x4==x2 || x4==x1) continue;
						for(int x5=1;x5<=9;x5++){
							if(x5==x4 || x5==x3 || x5==x2 || x5==x1) continue;
							if((x1+x2+x3+x4+x5) % 5 != 0)
								continue;
							
							for(int x6=1;x6<=10;x6++){
								if(x6==x5 || x6==x4 || x6==x3 || x6==x2 || x6==x1) continue;
								for(int x7=1;x7<=10;x7++){
									if(x7==x6 || x7==x5 || x7==x4 || x7==x3 || x7==x2 || x7==x1) continue;
									for(int x8=1;x8<=10;x8++){
										if(x8==x7 || x8==x6 || x8==x5 || x8==x4 || x8==x3 || x8==x2 || x8==x1) continue;
										for(int x9=1;x9<=10;x9++){
											if(x9==x8 || x9==x7 || x9==x6 || x9==x5 || x9==x4 || x9==x3 || x9==x2 || x9==x1) continue;
											for(int x10=1;x10<=10;x10++){
												if(x10==x9 || x10==x8 || x10==x7 || x10==x6 || x10==x5 || x10==x4 || x10==x3 || x10==x2 || x10==x1) continue;
												
												int s1 = x6+x1+x2;
												int s2 = x7+x2+x3;
												int s3 = x8+x3+x4;
												int s4 = x9+x4+x5;
												int s5 = x10+x5+x1;
												if(s1==s2 && s2==s3 && s3==s4 && s4==s5){
													int[] set = {x1,x2,x3,x4,x5,x6,x7,x8,x9,x10};
													String[] sset = new String[11];
													for(int i=0;i<10;i++)
														sset[i+1] = String.valueOf(set[i]);
													String res = "";
													//System.out.println(x1 + "\t"+x2 + "\t"+x3 + "\t"+x4 + "\t"+x5 + "\t"+x6 + "\t"+x7 + "\t"+x8 + "\t"+x9 + "\t"+x10 + "\t");
													for(int i=1;i<11;i++){
														//System.out.print(sset[i]+"\t");
													}
													//System.out.print("\n");
													
													int min = 11;
													for(int i=5;i<10;i++)
														min = Math.min(min, set[i]);
													if(min==x6)
														res=sset[6]+sset[1]+sset[2]
																+sset[7]+sset[2]+sset[3]
																+sset[8]+sset[3]+sset[4]
																+sset[9]+sset[4]+sset[5]
																+sset[10]+sset[5]+sset[1];
													else if(min==x7)
														res=sset[7]+sset[2]+sset[3]
																+sset[8]+sset[3]+sset[4]
																+sset[9]+sset[4]+sset[5]
																+sset[10]+sset[5]+sset[1]
																+sset[6]+sset[1]+sset[2];
													else if(min==x8)
														res=sset[8]+sset[3]+sset[4]
																+sset[9]+sset[4]+sset[5]
																+sset[10]+sset[5]+sset[1]
																+sset[6]+sset[1]+sset[2]
																+sset[7]+sset[2]+sset[3];
													else if(min==x9)
														res=sset[9]+sset[4]+sset[5]
																+sset[10]+sset[5]+sset[1]
																+sset[6]+sset[1]+sset[2]
																+sset[7]+sset[2]+sset[3]
																+sset[8]+sset[3]+sset[4];
													else if(min==10)
														res=sset[10]+sset[5]+sset[1]
																+sset[6]+sset[1]+sset[2]
																+sset[7]+sset[2]+sset[3]
																+sset[8]+sset[3]+sset[4]
																+sset[9]+sset[4]+sset[5];
													if(res.length()==16){
														//System.out.println(res);
														r.add(res);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Collections.sort(r);
		System.out.println(r);
	}
}
