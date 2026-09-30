class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1f = new int[26];
        int[] s2f = new int[26];

        int n2 = s2.length();
        int n1 = s1.length();

        if(n2<n1)return false;

        for(int k = 0;k< n1;k++){
            char c = s1.charAt(k);
            s1f[c-'a']++;
        }

        int j = 0;
        int i = 0;
        while(j<n2){
            char c = s2.charAt(j);
            s2f[c-'a']++;
            if(j-i==n1-1){
                if(compare(s1f,s2f))return true;
                char prev = s2.charAt(i);
                s2f[prev-'a']--;
                i++;
            }
            j++;
        }

        return false;
    }

    private boolean compare(int[] a,int[] b){
        for(int i = 0; i< 26;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }
}
