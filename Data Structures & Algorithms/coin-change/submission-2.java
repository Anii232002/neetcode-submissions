class Solution {
    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        int val = dp(0,coins,amount);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    private int dp(int i,int[] coins,int amount){
        if(amount==0 )return 0;
        if(i >= coins.length)return Integer.MAX_VALUE;
        

        int take = Integer.MAX_VALUE;
        if(amount >= coins[i]){
           take = dp(i,coins,amount-coins[i]);
           if(take != Integer.MAX_VALUE){
                take ++;
           }
        }
        int notake = dp(i+1,coins,amount);
        return Math.min(take,notake);
    }
}
