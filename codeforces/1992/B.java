/*
* https://codeforces.com/contest/1992/problem/B
* We need to slize everythin to 1 and then merge them, except maximum of array
* */
// package org.donga;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int sum=s.nextInt();
            int n=s.nextInt();
            int [] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            int ans=0;
            int max=0;
            for(int x:arr){
                if(x>1){
                    ans+=x-1;
                }
                ans+=x;
                max=Math.max(max,x);
            }
            ans=ans-max;
            if(max>1){
                ans-=(max-1);
            }
            System.out.println(ans);
        }
    }
}
