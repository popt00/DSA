class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        while(numRows-->0){
            List<Integer> temp= new ArrayList<>();
            List<Integer> lastRow = list.size()==0?new ArrayList<>():list.get(list.size()-1);
            int i=0;
            for(Integer x: lastRow){
                temp.add(i+x);
                i=x;
            }
            temp.add(1);
            list.add(temp);
        }
        return list;
    }
}
