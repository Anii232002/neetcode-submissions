class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubSet(0,nums,new ArrayList<>(),ans);
        return ans;
    }

    private void findSubSet(int i , int[] nums,List<Integer> curr, List<List<Integer>> ans){

        if(i==nums.length){
            if(!ans.contains(curr)){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(nums[i]);
        findSubSet(i+1,nums,curr,ans);
        curr.remove(curr.size()-1);
        findSubSet(i+1,nums,curr,ans);
        
    }
}
