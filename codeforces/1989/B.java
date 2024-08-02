/*
 * https://codeforces.com/contest/1989/problem/B
 *
 * */
// package org.donga;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class B{
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();s.nextLine();
        while(t-->0){
            String str=s.nextLine();
            String str2=s.nextLine();
            int max=0;
            for(int i=0;i<str2.length();i++){
                int index=0, index2=i;
                while(index<str.length() && index2<str2.length()){
                    if(str.charAt(index)==str2.charAt(index2)){index2++;}
                    index++;
                }
                max=Math.max(max,index2-i);
            }
            System.out.println(str.length()+str2.length()-max);
        }
    }

}

