class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms=0;
        int i=0,j=0,currPlat=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                currPlat++;
                i++;
            }
            else{
                currPlat--;
                j++;
            }
            platforms=Math.max(platforms,currPlat);
        }
        return platforms;
    }
}
