/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * Solution20 answer
 *
 * @since 2020-01-13
 */
public class Template {
    /**
     * check formula is vailid.
     *
     * @param s input formula string
     * @return is valid result
     */
    boolean isValid(String s) {
        return true;
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
