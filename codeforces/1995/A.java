/*
* https://codeforces.com/contest/1995/problem/A
* add to middle diagonal first and then diagonal beside it both sides
* */
//package org.donga;
import java.util.Arrays;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int ans=0;
            while(k>0){
                k-=n;
                if(ans%2==0)n--;
                ans++;
            }
            System.out.println(ans);
        }
    }
}
