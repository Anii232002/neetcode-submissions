class Solution {
    private String delimiter = "&";
    private String charDelimiter = "#";
    public String encode(List<String> strs) {
        String ans = "";
        for(int i = 0; i< strs.size(); i++){
            String curr = strs.get(i);
            ans += convertToAscii(curr)+delimiter;
        }
        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if(str.equals("")){
            return ans;
        }
        String[] arr = str.split(delimiter);
        for(int i = 0; i< arr.length; i++){
            String decoded = convertToString(arr[i]);
            ans.add(decoded);
        }
        return ans;
    }

    private String convertToAscii(String str){
        String ascii = str.length()+"#";
        char[] charArray = str.toCharArray();
        //str to ascii
        for(char c : str.toCharArray()){
            ascii += (int)c + charDelimiter;
        }
        return ascii;
    }

    private String convertToString(String str){
        String ans = "";
        
        //ascii to str
        //what about in character ascii (double digit and single digit) delimiter ?
        String[] charArray = str.split(charDelimiter);
        // System.out.println(str);
        int len = Integer.parseInt(charArray[0]);
        if(len == 0){
            return "";
        }
        // System.out.println(str+" "+charArray.length);
        for(int i = 1; i< charArray.length; i++){
            String s = charArray[i];
            // System.out.println("===>"+s+" "+s.length());
            int asciiValue = Integer.parseInt(s);
            //  System.out.println("done");
            ans += (char)(asciiValue);
        }
        return ans;
    }
}
