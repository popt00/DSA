public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        if(m==1)return 1;
        int st=2,ed=m;
        while(st+1<ed){
            int mid= (st+ed)/2;
            int compare= compare(mid,n,m);
            if(compare==0)return mid;
            if(compare<0)st=mid;
            else ed=mid;
        }
        if(compare(st,n,m)==0)return st;
        if(compare(ed,n,m)==0)return ed;
        return -1;
    }
    public static int compare(int a, int ex, int val){
        long b=a;
        while(--ex>0){
            b*=a;
            if(b>val)return 1;
        }
        if(b>val)return 1;
        if(b<val)return -1;
        return 0;
    }
}
