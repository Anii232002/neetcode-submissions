class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int n = piles.length;
        for(int i = 1; i< n;i++){
            max = Math.max(piles[i],max);
        }

        int min = 1;
        int ans = 1;
        while(min<=max){
            int mid = min + (max-min)/2;
            System.out.println("min = "+min+" max = "+max+" mid = "+mid);
            int currH = calculateHours(mid,piles,n);
            if(currH > h ){
                // System.out.println("MORE");
                min = mid+1;
            }else{
                // System.out.println("LESS"+currH);
                max = mid-1;
            }

        }
        return min;
    }

    private int calculateHours(int k,int[] piles,int n){
        int hrs = 0;
        for(int i = 0; i< n; i++){
            double currH = (piles[i] * 1.0 / k * 1.0);
            int h = (int) Math.ceil(currH); 
            hrs+= h;
        }
        return hrs;
    }
}
