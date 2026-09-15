class Solution {

    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        return Math.max(dfs(0,nums,nums.length-1,dp1),dfs(1,nums,nums.length,dp2));
    }

    private int dfs(int i,int[] nums,int end,int[] dp){
        if(i>=end)return 0;

        if(dp[i] != -1)return dp[i];
        int take = dfs(i+2,nums,end,dp) + nums[i];
        int notake = dfs(i+1,nums,end,dp);

        return dp[i] =  Math.max(take,notake);
    }
}
