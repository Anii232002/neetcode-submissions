class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>> map = new HashMap<>();

       for(int i = 0; i< strs.length; i++){
        String curr = strs[i];
        int[] currArr = new int[26];
        for(int j = 0; j< curr.length() ; j++){
            char c = curr.charAt(j);
            currArr[(int)c-'a']++;
        }
        String key = Arrays.toString(currArr);
        List<String> value = map.getOrDefault(key,new ArrayList<>());
        value.add(curr);
        map.put(key,value);
       }
        List<List<String>> ans = new ArrayList<>();
       for(Map.Entry<String,List<String>> e: map.entrySet()){
            ans.add(e.getValue());
       } 
       return ans;
    }
}
