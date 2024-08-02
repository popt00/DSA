/*
 * https://codeforces.com/contest/1989/problem/C
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
            int ar[]=new int[n];
            for(int i=0;i<n;i++){ar[i]=s.nextInt();}
            int br[]=new int[n];
            for(int i=0;i<n;i++){br[i]=s.nextInt();}
            int a=0,b=0,pos=0, neg=0;
            for(int i=0;i<n;i++){
                if(ar[i]==-1){
                    if(br[i]==-1)neg++;
                    else b+=br[i];
                }
                else if(ar[i]==0){
                    if(br[i]==1)b++;
                }
                else if(ar[i]==1){
                    if(br[i]==1)pos++;
                    else a++;
                }
            }
            while(pos!=0){
                if(a<b)a++;
                else b++;
                pos--;
            }
            while(neg!=0){
                if(a<b)b--;
                else a--;
                neg--;
            }
            System.out.println(Math.min(a,b));;
        }
    }
}
