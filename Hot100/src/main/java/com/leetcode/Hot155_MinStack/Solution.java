package com.leetcode.Hot155_MinStack;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    Deque<Integer> xstack;
    Deque<Integer> minStack;
    public MinStack() {
        xstack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xstack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        xstack.pop();
        minStack.pop();
    }

    public int top() {
        return xstack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
