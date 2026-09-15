class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase().trim();        
        for(int i = 0 ; i< s.length(); i++){
            char c = s.charAt(i);
            int ascii = (int)c;
            if((c>=97 && c<=122)||(c>=48 && c<=56)){
                sb.append(s.charAt(i));
            }
        }

        return validPalindrome(sb.toString());
    }

    private boolean validPalindrome(String s){
        int i = 0;
        int j = s.length()-1;

        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
