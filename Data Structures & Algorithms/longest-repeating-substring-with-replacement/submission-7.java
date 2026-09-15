class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int ans = 0;
        int max = 0;
        while(j < s.length() ){
            char currentChar = s.charAt(j);
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);
            max = Math.max(max,map.get(currentChar));
           
            while((j-i+1)-max > k){
                char prevChar = s.charAt(i);
                map.put(prevChar,map.get(prevChar)-1);
                i++;
                
            }
            ans = Math.max(ans,j-i+1);
            j++;

        }

        return ans;

    }

    public Character findLargest(HashMap<Character,Integer> map){
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
