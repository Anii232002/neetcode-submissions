class Solution {
     int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int islands = 0;
        int max = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    int[] count = new int[1];
                    dfs(i,j,grid,count);
                    max = Math.max(max,count[0]);

                }
            }
        }

        return max;
    }

    private void dfs(int i,int j,int[][] grid,int[] count ){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length)return;
        if(grid[i][j]==0)return;
        grid[i][j] = 0;
        count[0] = count[0] + 1;

        for(int x = 0; x< dirs.length; x++){
            int newI = i + dirs[x][0];
            int newJ = j + dirs[x][1];

            dfs(newI,newJ,grid,count);
        }
    }
}
