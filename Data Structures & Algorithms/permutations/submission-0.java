class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<Integer>();
        findPermutation(curr,set,nums,ans);

        return ans;
    }

    private void findPermutation(List<Integer> curr,HashSet<Integer> set,
    int[] nums,List<List<Integer>> ans){
        System.out.println(set);
        if(curr.size()==nums.length){
            System.out.println("ENTERED BRO"+" "+curr);
            if(!ans.contains(curr)){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i = 0; i< nums.length; i++){
            System.out.println("looping"+i);
            if(!set.contains(i)){
                curr.add(nums[i]);
                set.add(i);
                findPermutation(curr,set,nums,ans);
                curr.remove(curr.size()-1);
                set.remove(i);
            }
        }
    }
}
