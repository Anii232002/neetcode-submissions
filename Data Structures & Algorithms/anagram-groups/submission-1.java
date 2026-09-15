class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int j= 0;j< strs.length; j++){
            int[] charCount = new int[26];
            char[] charArray = strs[j].toCharArray();

            for(int i = 0; i< charArray.length; i++){
                char c = charArray[i];
                charCount[(int)c - (int)'a']++;
            }

            String key = Arrays.toString(charCount);

            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(strs[j]);

            map.put(key,list);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> e : map.entrySet()){
            ans.add(new ArrayList<>(e.getValue()));
        }
        return ans;
    }
}
