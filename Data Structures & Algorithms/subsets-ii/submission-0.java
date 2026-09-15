class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subset(0,nums,new ArrayList<>(),ans);
        return ans;
    }

    private void subset(int i,int[] nums,List<Integer> curr,List<List<Integer>> ans){


        if(i >= nums.length){
            if(!ans.contains(curr)){
                ans.add(new ArrayList<>(curr));
            }
           
            return;
        }
        curr.add(nums[i]);
        subset(i+1,nums,curr,ans);
        curr.remove(curr.size()-1);
        subset(i+1,nums,curr,ans);
    }
}
