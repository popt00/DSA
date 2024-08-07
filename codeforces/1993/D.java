//package org.donga;
import java.awt.*;
import java.util.*;
public class D {
    static int n;
    static int k;
    static int[] ar;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            n = s.nextInt();
            k = s.nextInt();
            ar = new int[n];
            int low=Integer.MAX_VALUE, high=Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                ar[i] = s.nextInt();
                low = Math.min(low, ar[i]);
                high = Math.max(high, ar[i]);
            }

            while(low<=high){
                int mid= (low+high)/2;
                if(check(mid)){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
            System.out.println(high);
        }
    }

    private static boolean check(int mid) {
        int [] b=new int[n];
        int [] dp = new int[n];
        for(int i=0; i<n; i++){
            if(ar[i]<mid){
                b[i]=-1;
            }
            else b[i]=1;
        }

        dp[0]=b[0];
        for(int i=1; i<k && i<n ; i++)dp[i]=dp[i-1]+b[i];
        for(int i=k; i<n; i++){
            if(i%k==0){
                dp[i]=Math.max(dp[i-k],b[i]);
            }
            else{
                dp[i]=Math.max(dp[i-1]+b[i],dp[i-k]);
            }
        }
        return dp[n-1]>0;
    }
}
