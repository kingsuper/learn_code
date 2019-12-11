import org.junit.Assert;
import org.junit.Test;

public class Solution416 {
    public Solution416() {
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int[] var3 = nums;
        int var4 = nums.length;

        int i;
        int j;
        for(i = 0; i < var4; ++i) {
            j = var3[i];
            sum += j;
        }

        int target = sum / 2;
        if (target % 2 == 1) {
            return false;
        } else {
            boolean[][] dp = new boolean[nums.length][target + 1];

            for(i = 0; i < target + 1; ++i) {
                dp[0][i] = false;
                if (i == nums[0]) {
                    dp[0][i] = true;
                }

                System.out.print(i + ":" + dp[0][i]);
            }

            System.out.println();

            for(i = 1; i < nums.length; ++i) {
                for(j = 0; j < target + 1; ++j) {
                    dp[i][j] = dp[i - 1][j];
                    if (j > nums[i]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }

                    System.out.print(j + ":" + dp[i][j]);
                }

                System.out.println();
            }

            return dp[nums.length - 1][target];
        }
    }

    @Test
    public void testCanPartition() {
        int[] input = new int[]{1, 5, 11, 5};
        Assert.assertEquals(true, this.canPartition(input));
    }
}
