//https://codeforces.com/contest/2032/problem/A
// package codeforces;

//import java.util.Scanner;
import java.util.*;

public class Asolution {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		
		
		for(int i=0;i<t;i++) {
			int n = s.nextInt();
			int count1=0;
			for(int j=0;j<2*n;j++) {
				int x =s.nextInt();
				if(x==1)count1++;
			}
//			System.out.print(count1 +": ");
			int min = (count1%2==0 ? 0: 1);
			int max= (count1<=n ? count1 : 2*n-count1);
			System.out.println(min+" "+max);
			
		}
//		System.out.println(Arrays.toString(dp));
		
	}
}
