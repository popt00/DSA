class Solution {
    List<List<Integer>> ans;
    int n;
    int[] arr;
    List<Integer> currList;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n=nums.length;
        ans=new ArrayList<>();
        Arrays.sort(nums);
        arr=nums;
        currList=new ArrayList<>();
        recur(0);
        return ans;
    }
    public void recur(int index){
        if(index==n){
            ans.add(new ArrayList<>(currList));
            return;
        }
        int j=index,i=index;
        while(j<n && arr[j]==arr[index])j++;
        recur(j);
        while(i<j){
            currList.add(arr[i]);
            recur(j);
            i++;
        }
        i=index;
        while(i<j){
            currList.removeLast();
            i++;
        }
    }
}
