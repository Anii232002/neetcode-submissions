class Solution {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    islands ++;
                }
            }
        }

        return islands;
    }

    private void dfs(int i,int j,char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length)return;
        if(grid[i][j]=='0')return;
        grid[i][j] = '0';

        for(int x = 0; x< dirs.length; x++){
            int newI = i + dirs[x][0];
            int newJ = j + dirs[x][1];

            dfs(newI,newJ,grid);
        }
    }
}
