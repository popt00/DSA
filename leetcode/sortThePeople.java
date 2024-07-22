/*
* https://leetcode.com/problems/sort-the-people/description/
*/
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] index=new Integer[names.length];
        for(int i=0;i<names.length;i++)index[i]=i;
        Arrays.sort(index, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return Integer.compare(heights[b],heights[a]);
            }
        });
        String[] finalAns=new String[names.length];
        for(int i=0;i<names.length;i++)finalAns[i]=names[index[i]];
        return finalAns;
    }
}
