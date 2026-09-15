class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j= 1;
        int ans = 1;
        if(s.length()==0)return 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(j<s.length() && i<j){
            char currentChar = s.charAt(j);
            while((set.contains(currentChar))){
                char prevChar = s.charAt(i++);
                set.remove(prevChar);
            }
            ans = Math.max(ans,(j-i)+1);
            set.add(currentChar);
            j++;
        }

        return ans;
    }
}
