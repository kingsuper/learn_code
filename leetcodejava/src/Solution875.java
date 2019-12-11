import org.junit.Assert;
import org.junit.Test;

public class Solution875 {
    public Solution875() {
    }

    public int minEatingSpeed(int[] piles, int H) {
        long sum = 0L;
        int result = 0;

        for(int i= 0; i < piles.length;i++) {
            sum += (long)piles[i];
        }

        result = (int)(sum /H);
        if (result == 0) {
            return 1;
        } else {
            while(!check(piles, result, H)) {
                ++result;
            }

            return result;
        }
    }

    public static boolean check(int[] piles, int result, int H) {
        int time = 0;

        for(int i = 0; i < piles.length; i++) {

            time += piles[i]% result == 0 ? i / result : i / result + 1;
        }

        return time <= H;
    }

    @Test
    public void testTwoSum() {
        int[] testNums = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        int h = 823855818;
        int test1Target = 14;
        Assert.assertEquals((long)test1Target, (long)this.minEatingSpeed(testNums, h));
    }
}
