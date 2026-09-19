class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int a = stk.pop();
                int b = stk.pop();
                int ans = calc(s,b,a);
                stk.push(ans);
            }else{
                stk.push(Integer.parseInt(s));
            }
        }

        return stk.pop();
    }

    private int calc(String s,int a,int b){

                    if(s.equals("+")){
                        return a+b;
                    }else if(s.equals("-")){
                        return a-b;
                    }else if(s.equals("*")){
                        return a*b;
                    }else{
                        return a/b;
                    }
                    
        
    }
}

