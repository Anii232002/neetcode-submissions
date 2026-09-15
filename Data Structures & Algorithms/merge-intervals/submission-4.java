class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> interval = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        interval.add(new int[] {intervals[0][0],intervals[0][1]});

        for(int x = 1; x< intervals.length; x++){
            int[] i = intervals[x];
            if(i[0] <= interval.get(interval.size()-1)[1]){
                int[] curr = interval.remove(interval.size()-1);
                curr[1] = Math.max(i[1],curr[1]);
                interval.add(new int[] {curr[0],curr[1]});
            }
            else{
                interval.add(new int[] {i[0],i[1]});
            }
        }

        int[][] ans = new int[interval.size()][2];

        for(int i= 0; i< interval.size(); i++){
            int[] a = interval.get(i);
            ans[i] = a;
        }

        return ans;
    }
}
