class Solution {
    int maxLen(int arr[]) {
        // code here
        int n= arr.length,ans=0;
        int[] sumArr= new int[n];
        sumArr[0]=arr[0];
        for(int i=1;i<n;i++)sumArr[i]=sumArr[i-1]+arr[i];
        //for(int i=0;i<n;i++)System.out.print(sumArr[i]+",");
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(sumArr[i]==0)ans=Math.max(ans,i+1);
            if(map.containsKey(sumArr[i])){
                ans=Math.max(ans, i-map.get(sumArr[i]));
            }
            else {
                map.put(sumArr[i],i);
            }
        }
        return ans;
    }
}
