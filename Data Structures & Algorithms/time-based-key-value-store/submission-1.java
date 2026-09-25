class TimeMap {

    HashMap<String, ArrayList<Value>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        //O(1) 
        ArrayList<Value> list = map.getOrDefault(key, new ArrayList<Value>());
        Value val = new Value(value,timestamp);
        list.add(val);
        map.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        //Binary Search
        ArrayList<Value> list = map.getOrDefault(key, new ArrayList<Value>());
        int left = 0;
        int right = list.size()-1;
        String ans = "";
        while(left<=right){
            int mid = left + (right - left)/2;
            Value curr = list.get(mid);
            
            if(timestamp < curr.time){
                right = mid -1;
            }else{
                ans = list.get(mid).val;
                left = mid + 1;
            }
        }
        return ans;
    }
}

class Value
{
    int time;
    String val;

    Value(String val,int time){
        this.val = val;
        this.time = time;
    }
}
