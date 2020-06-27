package com.study.structure.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private Deque<Integer> in = new ArrayDeque<>();
    private Deque<Integer> out = new ArrayDeque<>();


    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!out.isEmpty()){
            in.push(out.pop());
        }
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!in.isEmpty()){
            out.push(in.pop());
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        while (!in.isEmpty()){
            out.push(in.pop());
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}