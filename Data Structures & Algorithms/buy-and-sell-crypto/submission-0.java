class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        int ans = 0;
        if(prices.length==0)return 0;
        int rightMax = prices[prices.length-1];
        for(int i = prices.length-2; i>=0; i--){
            int currentPrice = prices[i];
            int currentAns = rightMax-currentPrice;
            ans = Math.max(ans,currentAns);
            rightMax = Math.max(rightMax,currentPrice);
        }
        return ans;
    }
}
