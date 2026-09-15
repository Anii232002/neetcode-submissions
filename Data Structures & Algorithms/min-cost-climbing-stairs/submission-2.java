class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(recurse(0,cost,dp),recurse(1,cost,dp));

    }

    private int recurse(int i,int[] cost,int[] dp){
        if(i>cost.length-1){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        return dp[i] = Math.min(recurse(i+1,cost,dp),recurse(i+2,cost,dp))+cost[i];
    }
}
