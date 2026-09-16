class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int j = n-1;

        while(i<=j){
            int newValue = Math.min(heights[i],heights[j])*(j-i);
            ans = Math.max(ans,newValue);

            if(heights[j] < heights[i]){
                j--;
            }else{
                i++;
            }
        }
        
        return ans;
    }
}
