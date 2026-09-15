class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        updateCombinationSum(0,new ArrayList<>(),nums,target,ans);
        return ans;
    }

    private void updateCombinationSum(int i,List<Integer> curr,int[] nums,int target,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i==nums.length)return;
        if(target>=nums[i]){
            curr.add(nums[i]);
            updateCombinationSum(i,curr,nums,target-nums[i],ans);
            curr.remove(curr.size()-1);
        }
        updateCombinationSum(i+1,curr,nums,target,ans);
    }
}
