class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int ans = 0;
        ArrayList<Pair> list = new ArrayList<>();

        for(int i =0; i< n; i++){
            Pair p = new Pair(position[i],speed[i]);
            list.add(p);
        }

        list.sort((a, b) -> a.pos - b.pos);

        Stack<Double> stk = new Stack<>();

        for(Pair p : list){
            double currSpeed = calSpeed(p,target);

            while(stk.size()>0 && stk.peek()<=currSpeed){
                // System.out.println("popped"+stk.peek());
                stk.pop();
            }
            stk.push(currSpeed);
        }



        return stk.size();
    }

    public double calSpeed(Pair curr,int target){
        int diffCurr = (target - curr.pos);
        int speedCurr = curr.speed;
        double timeCurr = (diffCurr*1.0/speedCurr*1.0);
        // System.out.println(timeCurr);
        return timeCurr;

        
    }
}

class Pair{
    int pos;
    int speed;

    Pair(int pos,int speed){
        this.pos = pos;
        this.speed = speed;
    }
}
