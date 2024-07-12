/*
* https://codeforces.com/contest/1992/problem/B
* after analysing we need to minimize sum(g(i)) & maximize sum(f(i)): i=[1:n]
* minimize sum(g(i)): have 1,2,3....m 
* maximize sum(f(i)): have k,k-1.....m+1   :(till m+1 cause m<k)
* between those can be ordered in any way as both will cancel out in f(i)-g(i)
* */
package org.donga;
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
