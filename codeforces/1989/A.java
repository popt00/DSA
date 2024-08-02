/*
* https://codeforces.com/contest/1989/problem/A
* */
// package org.donga;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int x=s.nextInt();
            int y=s.nextInt();
            String ans="YES";
            if(y<-1)ans="NO";
            System.out.println(ans);
        }
    }
}
