class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];

        int i = 0 , j = 0;
        while(j < nums.length){
            while(sum < 0 ){
                sum = 0;
            }
            sum += nums[j++];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
