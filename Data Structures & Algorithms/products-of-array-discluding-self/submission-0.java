class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        left[0] = nums[0];
        right[n-1] = nums[n-1];

        for(int i = 1; i< n; i++){
            left[i] = left[i-1] * nums[i];
        }
        for(int i = n-2; i>=0; i--){
            right[i] = right[i+1] * nums[i];
        }

        for(int i = 0; i< n; i++)
        {
            int prev = 1;
            int next = 1;

            if(i-1>=0){
                prev = left[i-1];
            }

            if(i+1<n){
                next = right[i+1];
            }

            int curr = prev*next;

            ans[i] = curr;
        }

        return ans;

    }
}  
