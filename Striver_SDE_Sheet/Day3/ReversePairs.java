class Solution {
    private int counter=0;
    public int reversePairs(int[] nums) {
        counter=0;
        sort(nums,0,nums.length-1);
        //printt(0,nums,0,nums.length-1,0,0);
        return counter;
    }
    public void sort(int[] nums, int st, int ed){
        if(st+1==ed){
            count(nums,st,st,ed,ed);//4,2. -1,-1. -3,-2
            if(nums[st]>nums[ed]){ 
                int temp=nums[st];nums[st]=nums[ed];nums[ed]=temp;
            }
            return;
        }
        if(st==ed)return;
        int m=(st+ed)/2;
        sort(nums,st,m);
        sort(nums,m+1,ed);
        count(nums,st,m,m+1,ed);
        merge(nums,st,m,ed);
    }
    public void printt(int adder, int[] nums, int i, int j, int a, int b){
        System.out.print(adder+":("+i+","+j+":"+a+","+b+") [");
        for(int printI=i;printI<=j;printI++)System.out.print(nums[printI]+",");
        System.out.print("][");
        for(int printI=a;printI<=b;printI++)System.out.print(nums[printI]+",");
        System.out.println("]");
    }
    public void count(int[] nums, int i, int j, int a, int b){
        // i,j     <     a,b 
        // indI     <       indA
        // find : nums[indI]  > 2*nums[indA]
        int adder=0;
        int indI=i, indA=a;
        while(indI<=j && indA<=b){
            if(1L*nums[indI]<=2L*nums[indA]){
                indI++;
            }
            else{ // [indI,....,j] > 2*nums[indA] : add (j-indI+1) to count
                counter+= (j-indI+1);adder+= (j-indI+1);
                indA++;
            }
        }
        //printt(adder,nums,i,j,a,b);
    }
    public void merge(int[] nums, int st, int mid, int ed){
        int[] arr=new int[ed-st+1];
        int indArr=0,iSt=st,iEd=mid+1;
        while(iSt<=mid && iEd<=ed){
            if(nums[iSt]<=nums[iEd])
                arr[indArr++]=nums[iSt++];
            else 
                arr[indArr++]=nums[iEd++];
        }
        while(iSt<=mid)arr[indArr++]=nums[iSt++];
        while(iEd<=ed)arr[indArr++]=nums[iEd++];
        indArr=0;
        while(indArr<arr.length){
            nums[st+indArr]=arr[indArr];
            indArr++;
        }
    }
}
