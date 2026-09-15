class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i = 0; i< n ; i++){
            int ans = canComplete(i,i,gas,cost,0,true);
            if(ans != -1)return ans;
        }
        return -1;
    }

    private int canComplete(int i,int st, int[] gas, int[] cost,int availableGas,boolean isStart){
        if(i == st && !isStart)return st;
        int nextDestination = (i+1)%(gas.length);
        int requiredGas = cost[i];
        int currentGas = availableGas + gas[i];
        // System.out.println(st+" "+i+" "+currentGas+" "+requiredGas);
        if(requiredGas > currentGas)return -1;
        
        return canComplete(nextDestination,st,gas,cost,currentGas-requiredGas,false);
    }
}
