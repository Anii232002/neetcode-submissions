class Solution {
    public boolean canJump(int[] nums) {
        return canReach(0,nums);
    }
    private boolean canReach(int i, int[] nums){
        
        if( i == nums.length-1){
            return true;
        }

        for(int j = 1; j<= nums[i]; j++){
            int nextIndex = j + i;
            if(nextIndex >= nums.length)continue;
            if(canReach(nextIndex,nums))return true;
        }

        return false;
    }
}
