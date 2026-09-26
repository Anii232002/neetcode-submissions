class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        while(i<=j && j<n){
            char next = s.charAt(j);
            while(i<=j && set.contains(next)){
                char curr = s.charAt(i);
                // System.out.println("removed i = "+i);
                set.remove(curr);
                i++;
            }
            set.add(next);
            j++;
            // System.out.println("i ="+i+" j = "+j);
            ans = Math.max(ans,set.size());
        }
        return ans;
    }
}
