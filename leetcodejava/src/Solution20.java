/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Solution20 answer,try to analysis formula is correct
 *
 * @since 2019-12-20
 */
public class Solution20 {
    /**
     * check formula is vailid.
     *
     * @param s1 input formula string
     * @return is valid result
     *
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> keymaps = new HashMap<>();
        keymaps.put(')', '(');
        keymaps.put(']', '[');
        keymaps.put('}', '{');
        keymaps.put('#','#');
        for (int i = 0; i < s.length(); i++) {
            if (keymaps.containsKey(s.charAt(i))) {
                char topChar = stack.isEmpty() ? '#' : stack.pop();
                if (keymaps.get(s.charAt(i)) != topChar) {
                    return false;
                }
            }
            if (keymaps.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    /**
     * test check formula
     */
    @Test
    public void testCanPartition() {
        String input = "]";
        String input2 = "([)]";

        Assert.assertEquals(false, this.isValid(input));
        Assert.assertEquals(false, this.isValid(input2));
    }
}
