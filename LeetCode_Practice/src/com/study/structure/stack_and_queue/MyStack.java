package com.study.structure.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> in;
    private Queue<Integer> out;

    /** Initialize your data structure here. */
    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        out.offer(x);
        if(out.size() > 1){  // out只留一个元素即可
            in.offer(out.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = out.poll();
        // 两步实现反转
        while(!in.isEmpty()){
            out.offer(in.poll());
        }
        while(out.size()>1){
            in.offer(out.poll());
        }
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return out.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */