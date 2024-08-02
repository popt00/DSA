//package org.donga;
// TLE
//https://codeforces.com/contest/1989/problem/D
import java.awt.*;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int t = s.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][1] = s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr[i][0] = arr[i][1]-s.nextInt();
        }
        ArrayList<int[]> ar = helper(arr);
//        for(int i = 0; i < ar.size(); i++){System.out.print(Arrays.toString(ar.get(i)));}System.out.println("");
        long ans=0;
        int cr[]=new int[t];
        for (int i = 0; i < t; i++) {
            cr[i]=s.nextInt();
        }
        Arrays.sort(cr);
        int len= ar.get(0)[1]+1;
        int[] dp= new int[len];
        int index=ar.size()-1;
        dp[0]=0;
        for(int i=ar.get(index)[1];i<len;i++){
            if(index>0 && i==ar.get(index-1)[1]){
                index--;
            }
            dp[i]=Math.max(dp[i-ar.get(index)[0]]+2,dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        for(int c: cr){
            ans= ans+ helper(ar,c, dp);
//            System.out.println("["+c+","+helper(ar,c, dp)+"]");
        }

        System.out.println(ans);
    }

    private static int helper(ArrayList<int[]> ar, int x, int[] dp) {
        int mul=0;
        if(x>dp.length-1){
            int max=ar.get(0)[1], minus=ar.get(0)[0];
            mul= (x-max)/minus+1;
            x-= mul*minus;
        }
//        System.out.println("mul:" + mul +",x:"+x);
        return dp[x]+mul*2;
    }

    private static ArrayList<int[]> helper(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> dp = new ArrayList<>();
        dp.add(arr[0]);
        for(int[] ar: arr) {
            int[] last=dp.get(dp.size()-1);
            if(last[0]==ar[0]) {last[1]=Math.min(last[1],ar[1]);}
            else{
                if(last[1]>ar[1])dp.add(ar);
            }
        }
        return dp;
    }
}
