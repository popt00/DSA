/*
 * https://codeforces.com/contest/1995/problem/C
 * complete: accepted
 * see blog : https://codeforces.com/blog/entry/131851
 * and this reference: https://codeforces.com/contest/1995/submission/273617012
 * */
// package org.donga;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class C{
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            long m=s.nextLong();
            long [][] p=new long[n][2];
            long ans=0;
            for(int i=0;i<n;i++){
                p[i][0]=s.nextLong();
            }
            for(int i=0;i<n;i++){
                p[i][1]=s.nextLong();
            }
            Arrays.sort(p,new Comparator<long[]>() {
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o1[0],o2[0]);
                }
            });
            for(int i=0;i+1<n;i++){
                ans=Math.max(ans,Math.min(p[i][1],m/p[i][0])*p[i][0]);
                if(p[i][0]+1==p[i+1][0]){
                    ans=Math.max(ans,helper(p[i],p[i+1],m));
                }
            }
            ans=Math.max(ans,Math.min(p[n-1][1],m/p[n-1][0])*p[n-1][0]);
            System.out.println(ans);
        }
    }
    public static long helper(long []a, long []b, long m){
        long a_count=Math.min(a[1],m/a[0]);
        long coins= m-a[0]*a_count;
        long b_count= Math.min(b[1],coins/b[0]);
        coins-=b_count*b[0];
        long exchangeAB= Math.min(Math.min(b[1]-b_count,a_count),coins);
        a_count-=exchangeAB;
        b_count+=exchangeAB;
        return a_count*a[0]+b_count*b[0];
    }
}
