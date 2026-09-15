class Solution {
    public boolean canJump(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        return canReach(0,nums,map);
    }
    private boolean canReach(int i, int[] nums,Map<Integer,Boolean> map ){
        if(map.containsKey(i))return map.get(i);
        if( i == nums.length-1){
            return true;
        }

         if(nums[i]==0){
            return false;
        }

        for(int j = 1; j<= nums[i]; j++){
            int nextIndex = j + i;
            if(nextIndex >= nums.length)continue;
            if(canReach(nextIndex,nums,map)){
                map.put(i,true);
                return true;
            }
        }
        map.put(i,false);
        return false;
    }
}
