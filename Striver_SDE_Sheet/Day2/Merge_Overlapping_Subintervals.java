class Solution {
    public int[][] merge(int[][] vals) {
        Arrays.sort(vals, new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            }
        });
        List<int[]> ans= new ArrayList<>();
        int[] preVal=new int[]{vals[0][0],vals[0][1]};
        ans.add(preVal);
        for(int[] x: vals){
            if(preVal[1]>=x[0]){
                if(preVal[1]<x[1])preVal[1]=x[1];
            }
            else{
                preVal= new int[]{x[0],x[1]};
                ans.add(preVal);
            }
        }
        int[][] ansAr= new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)ansAr[i]=ans.get(i);
        return ansAr;
    }
}
