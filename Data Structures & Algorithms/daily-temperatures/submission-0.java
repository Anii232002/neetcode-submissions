class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        Stack<Pair> stk = new Stack<>();
        int[] ans = new int[n];
        int j = 0;
        for(int i = 0; i< n; i++){
            int curr = temps[i];
            while(stk.size()>0 && stk.peek().i<curr){
                Pair rem = stk.pop();
                ans[rem.idx] = i-rem.idx;
            }
            Pair p = new Pair(curr,i);
            stk.push(p);
        }
        while(stk.size()>0 && j<n){
            Pair rem = stk.pop();
            ans[rem.idx] = 0;
        }
        return ans;
    }
}
class Pair {
    int i;
    int idx;

    Pair(int i,int idx){
        this.i = i;
        this.idx = idx;
    }
}
