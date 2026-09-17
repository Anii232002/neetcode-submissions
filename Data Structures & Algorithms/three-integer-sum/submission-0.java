class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< n; i++){
            twoSum(nums, -nums[i],i,ans);
        }
        return ans;
    }

    public void twoSum(int[] nums, int target,int idx, List<List<Integer>> ans) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i< n; i++){
            if(i==idx)continue;
            int req = target - nums[i];
            if(map.containsKey(req)){
                int key = map.get(req);
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(req);
                curr.add(nums[i]);
                curr.add(-target);
                Collections.sort(curr);
                if(!ans.contains(curr)){
                    ans.add(curr);
                }
                
            }
            map.put(nums[i],i);
        }

    }
}
