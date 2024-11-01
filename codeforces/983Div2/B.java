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
			int k= s.nextInt();
//						
			if(n==1) {
				if(k==1)System.out.println("1\n1");
				else System.out.println("-1");
				continue;
			}
			if(k==n || k==1) {
				System.out.println("-1");
				continue;
			}
			System.out.println("3");
			int st,ed;
			if(k==n/2+1) {
				st=2;ed=n-1;
			}
			else if(k<n/2+1){
				st=2;
				ed=k-2+k;
			}
			else {
				ed=n-1;
				st= k- (ed-k);
			}
			System.out.println(1+" "+ st+" "+(ed+1));
			
		}
//		System.out.println(Arrays.toString(dp));
		
	}
}
