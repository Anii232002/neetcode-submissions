class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n){
              System.out.println(i);
            if(nums[i] == (i+1)){
                nums[i] = -1;
                i++;
                continue;
            }
          
            while( nums[i] != -1){
                
                int temp =nums[i];
                int j = nums[nums[i]-1];
                if(j == -1 || j==temp)return nums[i];
                nums[i] = j;
                nums[temp-1] = temp;

                if(nums[i] == (i+1)){
                    nums[i] = -1;
                    break;

                }
            }
            i++;
        }

   
        return -1;
    }
}
