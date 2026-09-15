class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[i].length; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        int min = 0;
        while(q.size()>0){
            int size = q.size();
            boolean isNew = false;
            while(size --> 0){
                Pair rem = q.remove();

                int curr_x = rem.x;
                int curr_y = rem.y;

                for(int i = 0; i< dirs.length; i++){
                    int new_x = curr_x + dirs[i][0];
                    int new_y = curr_y + dirs[i][1];

                    if(new_x >= 0 && new_x < grid.length && new_y >=0 && new_y < grid[0].length && 
                    grid[new_x][new_y]==1){
                        grid[new_x][new_y] = 2;
                        isNew = true;
                        q.add(new Pair(new_x,new_y));
                    }
                }

            }
            if(isNew){
            min++;

            }
        }


        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[i].length; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return min;

    }
}

class Pair {
    int x;
    int y;

    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
