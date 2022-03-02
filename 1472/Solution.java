class BrowserHistory {
    Stack<String> history;
    Stack<String> forward;
    
    public BrowserHistory(String homepage) {
        history = new Stack<>();
        history.push(homepage);
        //reset forward stack
        forward = new Stack<>();
    }
    
    public void visit(String url) {
        history.push(url);
        //reset forward stack
        forward = new Stack<>();
    }
    
    public String back(int steps) {
        while(steps > 0 && history.size() > 1) { // Always keep at least one element in the stack. 
            forward.push(history.peek());
            history.pop();
            steps--;
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        while(steps > 0 && forward.size() > 0) {
            history.push(forward.peek());
            forward.pop();
            steps--;
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */