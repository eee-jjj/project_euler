package level4;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class P98 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("words.txt"));
		String line = br.readLine();
		line = line.replace("\"", "");
		String[] words = line.split(",");
		br.close();
		
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String word : words){
			char[] sig = word.toCharArray();
			Arrays.sort(sig);
			String wword = new String(sig);
			if(!map.containsKey(wword))
				map.put(wword, new ArrayList<String>());
			map.get(wword).add(word);
		}
		ArrayList<ArrayList<String>> anagram = new ArrayList<ArrayList<String>>();
		HashSet<Integer> lens = new HashSet<Integer>();
		ArrayList<int[]> six = new ArrayList(); 
		for(Entry<String, ArrayList<String>> e:map.entrySet()){
			if(e.getValue().size()>=2){
				anagram.add(e.getValue());
				lens.add(e.getValue().get(0).length());
				if(e.getValue().get(0).length()==5){					
					System.out.println(e.getValue());
					String w1 = e.getValue().get(0);
					String w2 = e.getValue().get(1);
					int[] sig = {0,1,2,3,4};
					int[] pattern = new int[5];
					for(int i=0;i<w1.length();i++){
						for(int j=i+1;j<w1.length();j++){
							if(w1.charAt(i)==w1.charAt(j))
								sig[j]=sig[i];
						}
					}
					for(int i=0;i<w1.length();i++){
						for(int j=0;j<w2.length();j++){
							if(w1.charAt(i)==w2.charAt(j))
								pattern[j]=sig[i];
						}
					}
					six.add(pattern);
					for(int i=0;i<pattern.length;i++)
						System.out.print(pattern[i]+",");
					System.out.println();
				}
			}
		}		
		HashMap<String, ArrayList<Long>> mapp = new HashMap<String, ArrayList<Long>>(); 
		for(long x=1;x<31623;x++){
			long xx = x*x;
			char[] sx = String.valueOf(xx).toCharArray();
			Arrays.sort(sx);
			String nsx = new String(sx);
			if(!mapp.containsKey(nsx))
				mapp.put(nsx, new ArrayList<Long>());
			mapp.get(nsx).add(xx);
		}
		ArrayList<ArrayList<Long>> sqanagram = new ArrayList<ArrayList<Long>>();
		for(Entry<String, ArrayList<Long>> e:mapp.entrySet()){
			if(e.getValue().size()>=2){
				sqanagram.add(e.getValue());
			}
		}
		System.out.println(anagram);
		System.out.println(lens);
		for(ArrayList<Long> pair:sqanagram){
//			if(pair.get(0).toString().length()<9)
//				continue;
//			for(Long l1:pair){
//				for(Long l2:pair){
//					char[] cl1 = l1.toString().toCharArray();
//					char[] cl2 = l2.toString().toCharArray();
//					if(cl1[0]==cl2[3] && cl1[1]==cl2[8] && cl1[2]==cl2[5] && cl1[3]==cl2[6] && cl1[4]==cl2[7]
//							&& cl1[5]==cl2[2] && cl1[6]==cl2[0] && cl1[7]==cl2[4] && cl1[8]==cl2[1]){
//						System.out.println(l1);
//						System.out.println(l2);
//					}						
//				}
//			}
//			if(pair.get(0).toString().length()!=8)
//				continue;
//			for(Long l1:pair){
//				for(Long l2:pair){
//					char[] cl1 = l1.toString().toCharArray();
//					char[] cl2 = l2.toString().toCharArray();
//					HashSet<Character> set = new HashSet<Character>();
//					for(char c:cl1)
//						set.add(c);
//					if(set.size()==8 && cl1[0]==cl2[3] && cl1[1]==cl2[0] && cl1[2]==cl2[1] && cl1[3]==cl2[2] && cl1[4]==cl2[4]
//							&& cl1[5]==cl2[5] && cl1[6]==cl2[6] && cl1[7]==cl2[7]){
//						System.out.println(l1);
//						System.out.println(l2);
//					}						
//				}
//			}
			if(pair.get(0).toString().length()!=5)
				continue;
			for(Long l1:pair){
				char[] cl1 = l1.toString().toCharArray();
				for(int[] p : six){
					String nnl = "";
					for(int i=0;i<p.length;i++){
						nnl += cl1[p[i]];
					}
					Long newl = Long.valueOf(nnl);
					if(pair.contains(newl)){
						boolean check = true;
						for(int i=0;i<p.length;i++){
							for(int j=0;j<p.length;j++){
								if(nnl.charAt(i)==nnl.charAt(j)){
									check = check && p[i]==p[j];
								}
							}
						}
						if(check){
							System.out.println(l1 +"\t"+ nnl);
							for(int i=0;i<p.length;i++)
								System.out.print(p[i]+",");
							System.out.println();
						}
					}
				}
			}
		}
	}
}
