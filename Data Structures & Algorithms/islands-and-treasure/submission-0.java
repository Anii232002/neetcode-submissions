class Solution {

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
    
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.addLast(new Node(i,j));
                }
            }
        }

        bfs(grid, queue);
    }

    private void bfs( int[][] grid, ArrayDeque<Node> queue ){
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        int level = 0;
        while(queue.size()>0){

            int size = queue.size();

            while(size --> 0){
                Node rem = queue.removeFirst();
                grid[rem.i][rem.j] = Math.min(grid[rem.i][rem.j],level);
                for(int x= 0; x< dirs.length; x++){
                    int xI = dirs[x][0] + rem.i;
                    int xJ = dirs[x][1] + rem.j;
                    if(xI<0 || xI>=grid.length || xJ<0 || xJ>=grid[0].length)continue;
                    if(grid[xI][xJ] == Integer.MAX_VALUE){
                        queue.addLast(new Node(xI,xJ));
                    }
                }
            }

            level ++;
        }
        
    }

    public class Node {
        int i;
        int j;

        Node(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
}

