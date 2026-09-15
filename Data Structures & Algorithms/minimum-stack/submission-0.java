class MinStack {

    private Stack<Integer> mainStack ;
    private Stack<Integer> minStack ;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(mainStack.size()==0){
            minStack.push(val);
            mainStack.push(val);
            return;
        }

        int currMin = minStack.peek();
        currMin = Math.min(currMin,val);

        minStack.push(currMin);
        mainStack.push(val);

    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
