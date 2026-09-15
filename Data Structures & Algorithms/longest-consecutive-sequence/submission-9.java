class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        if(n==0)return 0;
        for(int i = 0; i< n; i++){
            set.add(nums[i]);
        }
        int ans = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< n ; i++){
            int val = nums[i]+1;
            int seq = 1;
            while(set.contains(val) && !map.containsKey(nums[i])){
                seq++;
                map.put(val,seq);
                val = val + 1;
            }
            map.put(nums[i],seq);
            ans = Math.max(ans,seq);
        }

        return ans;
    }
}
