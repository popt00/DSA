//https://codeforces.com/contest/2032/problem/A
//package codeforces;

//import java.util.Scanner;
import java.util.*;

public class Asolution {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		
		
		for(int i=0;i<t;i++) {
			int n = s.nextInt();
			int [] ar=new int[n];
			for(int j=0;j<n;j++)ar[j]=s.nextInt();
			Arrays.sort(ar);
			int k=0,min=n-1;
			for(int j=0;j<n-1;j++) {
				int sum=ar[j]+ar[j+1];
				while(k<n && ar[k]<sum)k++;
				min=Math.min(min, n-k+ j);
			}
			System.out.println(min);
						
		}
//		System.out.println(Arrays.toString(dp));
		
	}
}
