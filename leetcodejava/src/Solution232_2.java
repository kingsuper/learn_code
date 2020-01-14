/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

import org.junit.Test;

import java.util.Stack;

/**
 * Solution232 answer
 *
 * @since 2020-01-13
 */
public class Solution232_2 {
    private Stack<Integer> s1;

    private Stack<Integer> s2;

    /**
     * use stack to implement queue
     */
    public Solution232_2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * use stack to implement queue
     *
     * @param x the number push to queue
     */
    public void push(int x) {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    /**
     * return first element
     *
     * * @return int return queue first element
     */
    public int peek() {
        return s1.peek();
    }

    /**
     * return first element and remove
     *
     * * @return int return queue first element
     */
    public int pop() {
        return s1.pop();
    }

    /**
     * return first element and remove
     *
     * * @return int return queue first element
     */
    public boolean empty() {
        return s1.empty();
    }

    /**
     * test check formula
     */
    @Test
    public void testSolution232() {
        Solution232_2 queue = new Solution232_2();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.s1.toString());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.s1.toString());
        System.out.println(queue.empty());
    }
}
