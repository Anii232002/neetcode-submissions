class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i< m;i++){
            for(int j = 0;j< n; j++){

                if(board[i][j]=='O' && isBorder(i,j,m,n)){
                    convert(i,j,board);
                }
            }
        }

        for(int i = 0; i< m;i++){
            for(int j = 0;j< n; j++){

                if(board[i][j]=='I'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void convert(int i,int j,char[][] board){
        if(i>=0 && i<board.length && j>=0 && j< board[i].length &&
        board[i][j]=='O'){
            board[i][j] = 'I';
            for(int x = 0; x < dirs.length; x++){
                int new_i = i + dirs[x][0];
                int new_j = j + dirs[x][1];
                convert(new_i,new_j,board);
            }

        }
        
    }

    private boolean isBorder(int i,int j,int m,int n){
        return (i==0 || j==0 || i==m-1 || j==n-1);
    }
}
