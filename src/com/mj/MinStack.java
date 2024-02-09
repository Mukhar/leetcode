package com.mj;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mins;
    public MinStack() {
    this.stack = new Stack<>();
    this.mins = new Stack<>();  
  
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(this.mins.isEmpty() || val<=this.mins.peek()){
            this.mins.push(val);
        }
    }
    
    public void pop() {
        int val = this.stack.pop();
        if (val==this.mins.peek()){
            this.mins.pop();
            if(this.mins.isEmpty() || this.stack.peek()<this.mins.peek())
                if(!this.stack.isEmpty())
                    this.mins.push(this.stack.peek());
            }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.mins.peek();
    }
}