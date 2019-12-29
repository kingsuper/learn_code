/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * Solution20 answer,try to analysis formula is correct
 *
 * @since 2019-12-20
 */
public class Solution494 {
    int result = 0;

    /**
     * check formula is vailid.
     *
     * @param nums input formula string
     * @param S input formula string
     * @return is valid result
     */
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return result;
    }

    private void calculate(int[] nums, int index, int sum, int target) {
        if (index == nums.length ) {
            if (sum == target) {
                result++;
            }
        } else {
            calculate(nums, index + 1, sum + nums[index], target);
            calculate(nums, index + 1, sum - nums[index], target);
        }
    }

    /**
     * test check formula
     */
    @Test
    public void test() {
        int[] input = new int[] {1, 1, 1, 1, 1};
        int target = 3;
        Assert.assertEquals(5, this.findTargetSumWays(input, target));
    }
}
