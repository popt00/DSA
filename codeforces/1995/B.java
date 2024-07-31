/*
 * https://codeforces.com/contest/1995/problem/B
 * see C for details which is done by : https://codeforces.com/contest/1995/submission/273617012
 * */
package org.donga;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class B{
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            long m=s.nextLong();
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextLong();
            }
            Arrays.sort(arr);
            ArrayList<long[]> ar=new ArrayList<>();
            long count=0,st=-1;
            long[] temp;
            for(long x:arr){
                if(x==st)count++;
                else{
                    temp=new long[]{st,count};
                    if(temp[0]!=-1)ar.add(temp);
                    count=1;
                    st=x;
                }
            }
            temp=new long[]{st,count};ar.add(temp);
            n=ar.size();
            //System.out.println(n);for(long[]arr1:ar){System.out.print(Arrays.toString(arr1)+",");}System.out.println("");
            long [][] p=new long[n][2];
            for(int i=0;i<ar.size();i++){p[i]=ar.get(i);}
            long ans=0;
            Arrays.sort(p,new Comparator<long[]>() {
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o1[0],o2[0]);
                }
            });
            for(int i=0;i+1<n;i++){
                ans=Math.max(ans,Math.min(p[i][1],m/p[i][0])*p[i][0]);
                if(p[i][0]+1==p[i+1][0]){
                    ans=Math.max(ans,helper(p[i],p[i+1],m));
                }
            }
            ans=Math.max(ans,Math.min(p[n-1][1],m/p[n-1][0])*p[n-1][0]);
            System.out.println(ans);
        }
    }
    public static long helper(long []a, long []b, long m){
        long a_count=Math.min(a[1],m/a[0]);
        long coins= m-a[0]*a_count;
        long b_count= Math.min(b[1],coins/b[0]);
        coins-=b_count*b[0];
        long exchangeAB= Math.min(Math.min(b[1]-b_count,a_count),coins);
        a_count-=exchangeAB;
        b_count+=exchangeAB;
        return a_count*a[0]+b_count*b[0];
    }
}
