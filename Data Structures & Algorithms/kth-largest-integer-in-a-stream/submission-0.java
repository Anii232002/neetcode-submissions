class KthLargest {
    int k;
    PriorityQueue<Integer> nums;

    public KthLargest(int k, int[] nums1) {
        this.nums = new PriorityQueue<Integer>((a,b)->b-a);
        for(int i = 0; i< nums1.length; i++){
            this.nums.add(nums1[i]);
        }
        this.k = k;
    }
    
    public int add(int val) {
        nums.add(val);
        Stack<Integer> stk = new Stack<>();
        int limit = k;
        while(limit!=0){
            stk.push(nums.remove());
            limit --;
        }
        int ans = stk.peek();
        while(stk.size()!=0){
            nums.add(stk.pop());
        }
        return ans;
    }
}
