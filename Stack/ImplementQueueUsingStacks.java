package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {

    private final Deque<Integer> inStack;
    private final Deque<Integer> outStack;

    /**
     * LeetCode #232 - Implement Queue using Stacks
     *
     * Implements a FIFO queue using two stacks.
     * Amortized Time Complexity: O(1) for push, pop, peek, and empty.
     * Space Complexity: O(N) to store elements across two stacks.
     */
    public ImplementQueueUsingStacks() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        shiftStacks();
        return outStack.pop();
    }

    public int peek() {
        shiftStacks();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
