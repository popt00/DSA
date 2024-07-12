/*
* https://codeforces.com/contest/1992/problem/C
* after analysing we need to minimize sum(g(i)) & maximize sum(f(i)): i=[1:n]
* minimize sum(g(i)): have 1,2,3....m
* maximize sum(f(i)): have k,k-1.....m+1   :(till m+1 cause m<k)
* between those can be ordered in any way as both will cancel out in f(i)-g(i)
* */
package org.donga;
import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int m=s.nextInt();
            int k=s.nextInt();
            StringBuilder sb=new StringBuilder();
            for(int i=n;i>m;i--){
                sb.append(i+" ");
            }
            for(int i=1;i<=m;i++){
                sb.append(i+" ");
            }
            System.out.println(sb.toString());
        }
    }
}
