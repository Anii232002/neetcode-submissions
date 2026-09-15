class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0)return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i = 0; i< hand.length; i++){
            freq.put(hand[i],freq.getOrDefault(hand[i],0)+1);
        }
        return initiateCalc(hand,groupSize,freq);
    }

    private boolean initiateCalc(int[] hand, int groupSize,HashMap<Integer,Integer> freq ){
        for(int i = 0; i< hand.length; i++){
            if(freq.get(hand[i])!=0){
                if(!createGroup(hand[i],freq,groupSize))return false;
            }
        }

        for(int i=0; i<hand.length ; i++){
            if(freq.get(hand[i])!=0)return false;
        }

        return true;
    }

    private boolean createGroup(int st,HashMap<Integer,Integer> freq,int groupSize){
        freq.put(st, freq.get(st)-1);
        for(int j = 1; j< groupSize; j++){
            int newMember = st+j;
            if(!freq.containsKey(newMember) || freq.get(newMember)==0)return false;
            freq.put(newMember, freq.get(newMember)-1);
        }
        return true;
    }
}
