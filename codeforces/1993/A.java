//package org.donga;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();s.nextLine();
            String str= s.nextLine();
            int[] ar=new int[4];
            for(char c: str.toCharArray()){
                if(c!='?')ar[(int)(c-'A')]++;
            }
            int ans=0;
            for(int i=0;i<4;i++){ans+=Math.min(ar[i],n);}
            System.out.println(ans);
        }
    }
}
