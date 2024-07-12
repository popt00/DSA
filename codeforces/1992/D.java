/*
* https://codeforces.com/contest/1992/problem/D
* in dp we are storing swimming remaining
* we just need to jump upto m and be greedy if there is log
* if there is water we need to swim to next and be greedy
* we are converting to array of int for faster process
* */
//package org.donga;
import java.util.Arrays;
import java.util.Scanner;
public class D {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int m=s.nextInt();
            int k=s.nextInt();
            s.nextLine();
            String st= "L"+s.nextLine();
            //0-> log , 1-> water, -1>crocodile
            int [] ar= toIntAr(st);

            int [] dp=new int[n+2];
            //for(int[] d: dp)Arrays.fill(d,Integer.MAX_VALUE);
            Arrays.fill(dp,Integer.MIN_VALUE);
            dp[0]=k;
            outer: for(int i=0;i<=n;i++){
                if(dp[i]<0)continue outer;
                if(ar[i]==0){
                    int x= Math.min(dp.length-1,i+m);
                    for(int j=i+1;j<=x;j++){
                        dp[j]=Math.max(dp[j],dp[i]);
                    }
                }
                else if(ar[i]==1){
                    if(i+1<dp.length)dp[i+1]=Math.max(dp[i+1],dp[i]-1);

                }
                else if(ar[i]==-1){
                    dp[i]=Integer.MIN_VALUE;
                }
            }
            System.out.println(Arrays.toString(ar)+"\n"+Arrays.toString(dp));
            if(dp[n+1]<0){
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }

    private static int[] toIntAr(String st) {
        int n=st.length();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(st.charAt(i)=='L'){
                arr[i]=0;
            }
            else if(st.charAt(i)=='W'){
                arr[i]=1;
            }
            else if(st.charAt(i)=='C'){
                arr[i]=-1;
            }
        }
        return arr;
    }
}
