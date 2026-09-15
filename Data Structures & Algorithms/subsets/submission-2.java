class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubSet(0,nums,new ArrayList<>(),ans);
        return ans;
    }

      private void findSubSet(int start, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr)); // add current subset (including empty one)

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            findSubSet(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}
