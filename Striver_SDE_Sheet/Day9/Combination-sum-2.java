class Solution {
    int[] arr;
    int sum;
    List<List<Integer>> ans;
    List<Integer> curr;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        arr=candidates;
        sum=target;
        ans=new ArrayList<>();
        curr=new ArrayList<>();
        recur(candidates.length-1);
        return ans;
    }
    public void recur(int i){
        if(sum<=0 || i<0){
            if(sum==0)ans.add(new ArrayList<>(curr));
            return;
        }
        int j=i,k=i;
        while(j>=0 && arr[j]==arr[i])j--;
        recur(j);
        while(j<k){
            sum-=arr[i];
            curr.add(arr[i]);
            recur(j);
            k--;
        }
        k=i;
        while(j<k){
            curr.removeLast();
            sum+=arr[i];
            k--;
        }
        
    }
}
