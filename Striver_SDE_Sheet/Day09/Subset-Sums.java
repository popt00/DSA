class Solution {
    ArrayList<Integer> ans;
    int n;
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        n=arr.length;
        ans=new ArrayList<>();
        recur(arr,0,0);
        return ans;
    }
    public void recur(int[] arr, int index, int sum){
        if(index==n){ans.add(sum);return;}
        recur(arr,index+1,sum);
        recur(arr,index+1,sum+arr[index]);
    }
}
