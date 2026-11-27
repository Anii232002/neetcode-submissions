class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("",0,0,n,ans);
        return ans;
    }

    public void generate(String curr, int open, int close,int n, List<String> ans){
        if(curr.length()==2*n && open == close){
            // if(!ans.contains(curr))
            ans.add(curr);
            return;
        }
        if(open > n)return;
        if(close < open){
            generate(curr+")",open,close+1,n,ans);
        }
        generate(curr+"(",open+1,close,n,ans);
    }
}
