package com.owodigi.stack;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class StackBasedQueue {

    class MyQueue {
        final Stack<Integer> push;
        final Stack<Integer> pop;

        public MyQueue() {
            this.push = new Stack<>();
            this.pop = new Stack<>();
        }

        private void move(final Stack<Integer> a, final Stack<Integer> b) {
            while (a.isEmpty() == false) {
                b.push(a.pop());
            }
        }

        public void push(int x) {
            move(pop, push);
            push.push(x);
        }

        public int pop() {
            move(push, pop);
            return pop.pop();

        }

        public int peek() {
            move(push, pop);
            return pop.peek();
        }

        public boolean empty() {
            return push.isEmpty() && pop.isEmpty();
        }
    }


    @Test
    public void testCase1() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        Assertions.assertEquals(1, myQueue.peek(), "queue.peek()"); // return 1
        Assertions.assertEquals(1, myQueue.pop(), "return 1, queue is [2]");
        Assertions.assertEquals(false, myQueue.empty(), "Queue.empty()"); // return false
    }
}
