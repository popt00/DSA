/*
 * https://codeforces.com/contest/1995/problem/C
 * uncomplete: wrong answer on test c
 * */
package org.donga;
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
            int [][] p=new int[n][2];
            long ans=0;
            for(int i=0;i<n;i++){
                p[i][0]=s.nextInt();
            }
            for(int i=0;i<n;i++){
                p[i][1]=s.nextInt();
                p[i][1]=Math.min(p[i][1],(int)(m/p[i][0]));
                ans=Math.max(ans,((long)p[i][1])*p[i][0]);
            }
            Arrays.sort(p,new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            for(int i=0;i+1<n;i++){
                if(p[i][0]+1==p[i+1][0]){
                    ans=Math.max(ans,helper(p[i],p[i+1],m));
                }
            }
            System.out.println(ans);
        }
    }
    public static long helper(int []a, int []b, long m){
        long p1=1l*a[0]*a[1];
        long p2=1l*b[0]*b[1];
        if(p1+p2<=m)return p1+p2;
        long coins= m-p1;
        long b_count= coins/b[0];
        coins-=b_count*b[0];
        long exchangeAB= Math.min(Math.min(b[1]-b_count,a[1]),coins);
        long max=((long)a[1]-exchangeAB)*a[0]+(b_count+exchangeAB)*b[0];
        //System.out.println(a[0]+"*"+(a[1]-exchangeAB)+"+"+b[0]+"*"+(b_count+exchangeAB)+"="+max+" :["+a[1]+","+b[1]+"].");
        return max;
    }
}
