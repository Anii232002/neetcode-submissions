class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(recurse(0,cost),recurse(1,cost));

    }

    private int recurse(int i,int[] cost){
        if(i>cost.length-1){
            return 0;
        }

        return Math.min(recurse(i+1,cost),recurse(i+2,cost))+cost[i];
    }
}
