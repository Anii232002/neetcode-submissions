class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(0,0,m,n);
    }

    private int dfs(int i,int j,int m,int n){
        if(i==m-1 && j==n-1)return 1;
        if(i>=m || j>=n || i<0 || j<0)return 0;

        return dfs(i+1,j,m,n) + dfs(i,j+1,m,n);
    }
}
