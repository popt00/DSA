/*
* https://leetcode.com/problems/sort-array-by-increasing-frequency/
*/
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x: nums)map.put(x, map.getOrDefault(x,0)+1);
        int[][] ar=new int[map.size()][2];
        int j=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ar[j][0]=entry.getKey();
            ar[j][1]=entry.getValue();
            j++;
        }
        Arrays.sort(ar, new Comparator<int[]>(){
            public int compare(int[]a, int[]b ){
                if(a[1]==b[1])return Integer.compare(b[0],a[0]);
                return Integer.compare(a[1],b[1]);
            }
        });
        int []ans=new int[nums.length];
        j=0;int indexAns=0;
        while(j!=ar.length){
            if(ar[j][1]==0){
                j++;
            }
            else{
                ar[j][1]--;
                ans[indexAns++]=ar[j][0];
            }
        }
        return ans;
    }
}
