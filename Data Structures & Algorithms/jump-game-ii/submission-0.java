class Solution {
    public int jump(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        return canReach(0,nums,map);
    }
    private int canReach(int i, int[] nums,Map<Integer,Integer> map ){

        if( i == nums.length-1){
            return 0;
        }

         if(nums[i]==0){
            return Integer.MAX_VALUE;
        }

        if(map.containsKey(i))return map.get(i);


        int actual = Integer.MAX_VALUE;

        for(int j = 1; j<= nums[i]; j++){
            int nextIndex = j + i;
            if(nextIndex >= nums.length)continue;
            int val = canReach(nextIndex,nums,map);

            if(val != Integer.MAX_VALUE){
                actual = Math.min(actual,val+1);
            }
            
        }
        map.put(i,actual);

        return actual == Integer.MAX_VALUE ? -1 : actual;
        
    }
}
