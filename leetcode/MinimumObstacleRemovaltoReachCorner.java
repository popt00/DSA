//https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
class Solution {
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;this.y=y;
        }
        public String toString(){
            return "("+String.valueOf(x)+","+String.valueOf(y)+")";
        }
    }
    public int minimumObstacles(int[][] grid) {
        int m= grid.length,n= grid[0].length;
        int [][] ar = new int[m][n];
        boolean[][] added= new boolean[m][n];
        for(int i=0;i<m;i++)Arrays.fill(ar[i],Integer.MAX_VALUE);
        
        ar[0][0]=grid[0][0]; 
        Point p = new Point(0,0);
        ArrayList<Point> list= new ArrayList<>();
        list.add(p);
        added[0][0]=true;
        
        while(ar[m-1][n-1]==Integer.MAX_VALUE){
            // System.out.println(list);
            // int size=list.size();
            //same add to list and 
            for(int i=0;i<list.size();i++){
                Point temp = list.get(i);
                int x= temp.x,y=temp.y;
                //addPoints(x,y,added,grid);
                if(x>0 && !added[x-1][y]&& grid[x-1][y]==0){
                    list.add(new Point(x-1,y));
                    ar[x-1][y]=ar[x][y];
                    added[x-1][y]=true;
                }
                if(x+1<m && !added[x+1][y]&& grid[x+1][y]==0){
                    list.add(new Point(x+1,y));
                    ar[x+1][y]=ar[x][y];
                    added[x+1][y]=true;
                }
                if(y>0 && !added[x][y-1]&& grid[x][y-1]==0){
                    list.add(new Point(x,y-1));
                    ar[x][y-1]=ar[x][y];
                    added[x][y-1]=true;
                }
                if(y+1<n && !added[x][y+1]&& grid[x][y+1]==0){
                    list.add(new Point(x,y+1));
                    ar[x][y+1]=ar[x][y];
                    added[x][y+1]=true;
                }
            }
            //added points now it's neighbors with added one if not visited
            int size= list.size();
            while(size-->0){
                Point temp = list.get(0);
                list.remove(0);
                int x= temp.x,y=temp.y;
                //addPoints(x,y,added,grid);
                if(x>0 && !added[x-1][y]&& grid[x-1][y]==1){
                    list.add(new Point(x-1,y));
                    ar[x-1][y]=ar[x][y]+1;
                    added[x-1][y]=true;
                }
                if(x+1<m && !added[x+1][y]&& grid[x+1][y]==1){
                    list.add(new Point(x+1,y));
                    ar[x+1][y]=ar[x][y]+1;
                    added[x+1][y]=true;
                }
                if(y>0 && !added[x][y-1]&& grid[x][y-1]==1){
                    list.add(new Point(x,y-1));
                    ar[x][y-1]=ar[x][y]+1;
                    added[x][y-1]=true;
                }
                if(y+1<n && !added[x][y+1]&& grid[x][y+1]==1){
                    list.add(new Point(x,y+1));
                    ar[x][y+1]=ar[x][y]+1;
                    added[x][y+1]=true;
                }
            }
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(ar[i][j]+",");
        //     }
        //     System.out.println("");
        // }
        return ar[m-1][n-1];
    }
}
