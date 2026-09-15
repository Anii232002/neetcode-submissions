class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < s.length() ){
            char currentChar = s.charAt(j);
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);
            char maxFreqChar = findLargest(map);
            int length = j-i+1;
            int replacements = length - map.get(maxFreqChar);

            while(replacements>k){
                char prevChar = s.charAt(i);
                map.put(prevChar,map.get(prevChar)-1);
                 i++;
                length = j-i+1;
                maxFreqChar = findLargest(map);
                replacements =  length - map.get(maxFreqChar);
                
            }
            ans = Math.max(ans,length);
            System.out.println(i+" "+j+" "+maxFreqChar+" "+ans);
            j++;

        }

        return ans;

    }

    public Character findLargest(HashMap<Character,Integer> map){
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
