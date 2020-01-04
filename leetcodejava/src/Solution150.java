/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author w00468379
 * @since 2019-12-25
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }

        }
        return stack.pop();
    }

    /**
     * test check formula
     */
    @Test
    public void testEvalRPN() {
        String[] input = new String[]{"2", "1", "+", "3", "*"};

        Assert.assertEquals(9, this.evalRPN(input));
    }
}


