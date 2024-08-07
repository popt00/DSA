/*
 *
 * */
//package org.donga;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            int maxOdd=-1;
            for(int i=0;i<n;i++){
                list.add(s.nextInt());
            }
            Collections.sort(list);
            int aMax= list.get(list.size()-1);
            int turnMin= list.get(list.size()-1);
            int turnMax= list.get(list.size()-1)+k-1;
            for(int i=0;i<list.size()-1;i++){
                int x=list.get(i);
                int mul=(aMax-x)/(2*k);
                int st = mul*2*k +x;
                int ed = st+k-1;
                if(ed<aMax){
                    st+=2*k;
                    ed+=2*k;
                }
                //System.out.print("["+x+":"+st+","+ed+"]");
                turnMin=Math.max(st,turnMin);
                turnMax=Math.min(ed,turnMax);
            }
            //System.out.println(".");
            int ans=-1;
            if(turnMax>=turnMin){ans=turnMin;}
            System.out.println(ans);
        }
    }
}
