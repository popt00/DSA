//https://codeforces.com/contest/2025/problem/B
import java.util.*;
 
public class Asolution {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		int len=100000+2, mod=1000000000+7;
		int[] dp = new int[len];
		dp[0]=1;
		for(int i=1;i<dp.length;i++) {
			dp[i]= (dp[i-1]*2)%mod;
		}
		
		for(int i=0;i<t;i++) {
			s.nextInt();
		}
//		System.out.println(Arrays.toString(dp));
		for(int i=0;i<t;i++) {
			System.out.println(dp[s.nextInt()]);
		}
	}
}
