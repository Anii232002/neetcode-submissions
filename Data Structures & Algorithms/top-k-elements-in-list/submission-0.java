class Solution {

    PriorityQueue pq = new PriorityQueue<Pair>((a,b) -> b.value - a.value);
    HashMap<Integer,Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];

        for(int i = 0; i< nums.length; i++){
            int value = map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],value);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            pq.add(new Pair(key,value));
        }
        int idx = 0;
        while(idx!=k){
            Pair rem = (Pair)pq.poll();
            ans[ans.length-idx-1] = rem.key;
            idx++;
        }

        return ans;
    }
}

class Pair{
    int key;
    int value;

    Pair(int key,int value){
        this.key = key;
        this.value = value;
    }
}
