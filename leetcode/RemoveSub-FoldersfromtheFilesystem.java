//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans=new LinkedList<>();
        String pre="TEMP AS THIS STRING DOES NOT EXIST";
        for(int i=0;i<folder.length;i++){
            String str=folder[i];
            if(str.equals(pre) || 
                    (   str.length()>pre.length() && 
                        str.substring(0,pre.length()).equals(pre) &&
                        str.charAt(pre.length())=='/'
                    )
                )
                continue;
            ans.add(str);
            pre=str;
        }
        return ans;
    }
}
