package com.mj;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> newStack = new Stack<>(); 
    public MyQueue() {
    }
    
    public void push(int x) {
        this.newStack.push(x);
    }
    
    public int pop() {
        Stack<Integer> newS= new Stack<>();
        while(!this.newStack.empty()){
            newS.push(this.newStack.pop());
        }
        int ans=newS.pop();
        while(!newS.empty()){
            this.newStack.push((newS.pop()));
        }
        return ans;
    }
    
    public int peek() {
        return this.newStack.peek();
    }
    
    public boolean empty() {
        if(this.newStack.size()==0)
            return true;
        return false;    
    }
}