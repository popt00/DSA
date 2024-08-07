/*
 *
 * */
//package org.donga;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            int maxOdd=-1;
            for(int i=0;i<n;i++){
                int x=s.nextInt();
                if(x%2==0){list.add(x);}
                else{
                    maxOdd=Math.max(maxOdd,x);
                }
            }
            int ans=0;
            if(maxOdd!=-1){
                Collections.sort(list);
                int i=0;
                while(i<list.size()){
                    int x=list.get(i);
                    if(x>maxOdd){
                         ans+=(list.size()-i+1);
                         break;
                    }
                    maxOdd=Math.max(maxOdd,x+maxOdd);
                    ans++;
                    i++;
                }
            }
            System.out.println(ans);
        }
    }
}
