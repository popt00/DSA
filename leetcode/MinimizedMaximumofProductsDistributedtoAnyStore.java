//https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
class Solution {
    public int minimizedMaximum(int n, int[] q) {    
        int st=1,ed=100000;
        while(st+1<ed){
            int mid = (st+ed)/2;
            if(canDistribute(q,n,mid))ed=mid;
            else st=mid;
        }
        if(canDistribute(q,n,st))return st;
        return ed;
    }
    public boolean canDistribute(int[] quatities, int n, int val){
        for(int q: quatities){
            n-=(q/val + (q%val==0?0:1));
            if(n<0)return false;
        }
        return true;
    }
}
