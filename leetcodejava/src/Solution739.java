/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Solution739:
 *
 * @since 2019-12-24
 */
public class Solution739 {
    /**
     * return how many day temp will raise.
     *
     * @param T input data list
     * @return data list show how many days temp will raise.
     */
    public int[] dailyTemperatures(int[] T) {
        int[] results = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i])
                stack.pop();
            results[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return results;
    }
/*    public int[] dailyTemperatures(int[] T) {
        int[] results = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            results[i] = 0;
            boolean isFind = false;
            for (int j = i + 1; j < T.length; j++) {
                results[i]++;
                if (T[j] > T[i]) {
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                results[i] = 0;
            }
        }
        return results;
    }*/


    /**
     * test dailyTemperatures
     */
    @Test
    public void testDailyTemperatures() {
        int[] inputs = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] outputs = new int[]{8,1,5,4,3,2,1,1,0,0};
        Assert.assertEquals(Arrays.toString(outputs), Arrays.toString(this.dailyTemperatures(inputs)));
    }

}
