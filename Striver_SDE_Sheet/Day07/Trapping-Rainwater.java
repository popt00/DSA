class Solution {
    public int trap(int[] arr) {
        int st=0,ed=arr.length-1;
        int maxSt=arr[st],maxEd=arr[ed];
        int ans=0;
        while(st<ed){
            if(arr[st]<=arr[ed]){
                st++;
                if(st<ed){
                    if(arr[st]<maxSt)ans+=maxSt-arr[st];
                    else maxSt=arr[st];
                }
            }
            else{
                ed--;
                if(st<ed){
                    if(arr[ed]<maxEd)ans+=maxEd-arr[ed];
                    else maxEd=arr[ed];
                }
            }
        }
        return ans;   
    }
}
