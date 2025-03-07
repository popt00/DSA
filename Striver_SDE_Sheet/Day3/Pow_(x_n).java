class Solution {
    public double myPow(double x, int n) {
        if(n<0)return myPow(1/x,-(n+1))* (1/x);
        double ans=1,temp=x;
        while(n!=0){
            if((n&1)==1)ans=ans*temp;
            temp=temp*temp;
            n= (n>>1);
        }
        return ans;
    }
}
