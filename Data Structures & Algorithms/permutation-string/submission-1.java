class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int k = 0; k< s1.length(); k++){
            c1[s1.charAt(k)-'a']++;
        }
       
        int i = 0;
        int j = 0;

        while(j< s1.length()){
            c2[s2.charAt(j)-'a']++;
            j++;
        }

        if(isEqual(c1,c2,s1))return true;

        while(j< s2.length()){
            c2[s2.charAt(i)-'a']--;
            c2[s2.charAt(j)-'a']++;
            if(isEqual(c1,c2,s1))return true;
            j++;
            i++;
        }

        return false;
    }

    private boolean isEqual(int[] c1,int[] c2,String s1){
        for(int i = 0; i< s1.length(); i++){
            if(c1[s1.charAt(i)-'a'] != c2[s1.charAt(i)-'a'])return false;
        }
        return true;
    }
}
