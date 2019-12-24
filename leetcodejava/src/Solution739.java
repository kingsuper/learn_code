/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
    }


    /**
     * test dailyTemperatures
     */
    @Test
    public void testDailyTemperatures() {
        int[] inputs = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] outputs = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        Assert.assertEquals(Arrays.toString(outputs), Arrays.toString(this.dailyTemperatures(inputs)));
    }

}
