//https://codeforces.com/contest/2025/problem/C
import java.util.*;

public class Asolution {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		
		
		for(int i=0;i<t;i++) {
			int n = s.nextInt();
			int k= s.nextInt();
			int[] ar = new int[n];
			SortedMap<Integer,Integer> map=new TreeMap<>();
			for(int j=0;j<n;j++) {
				ar[j]= s.nextInt();
			}
			Arrays.sort(ar);
//			System.out.println(map);
			int ans=0;
			List<Integer> dp=new LinkedList<>();
			int total=0,now=0, prev=ar[0];
			for(int j=0;j<n;j++){
				int curr=ar[j];
				if(curr==prev) {
					now++;
					total++;
				}
				else if(curr==prev+1) {
					dp.add(now);
					if(dp.size()==k) {
						total-=dp.removeFirst();
					}
					total++;
					now=1;
				}
				else {
					dp.clear();
					now=1;total=1;
				}
				ans=Math.max(ans, total);
				prev=curr;
//				System.out.println(dp.toString());
			}
			
			System.out.println(ans);
			
		}
//		System.out.println(Arrays.toString(dp));
		
	}
}
