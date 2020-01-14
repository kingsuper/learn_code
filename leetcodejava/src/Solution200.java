/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author w00468379
 * @since 2019-12-25
 */
public class Solution200 {
    /**
     * test check formula
     *
     * @param grid input data
     * @param row index row
     * @param column index column
     */
    public void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            return;
        } else if (grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }

    /**
     * check formula is vailid
     *
     * @param grid input data
     * @return nums of island
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * unit test method
     */
    @Test
    public void testNumIslands() {
        char[][] inputs = new char[][] {
            {'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, this.numIslands(inputs));
    }
}
