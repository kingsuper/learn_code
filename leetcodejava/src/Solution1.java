import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

    /* 第一个解法，暴力解法，双重循环，复杂度n的二次方。
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+ nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No solutions");*/

      /*
       第二种解法，通过HashMap空间换速度，利用Hash查询效率非常高。
       Map<Integer, Integer> numsMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int expectNum = target - nums[i];
            if (numsMap.containsKey(expectNum) && numsMap.get(expectNum)!=i){
                return new int[]{i,numsMap.get(expectNum)};
            }
        }
        throw new IllegalArgumentException("No solutions");*/

        Map<Integer, Integer> numsMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int expectNum = target - nums[i];
            if (numsMap.containsKey(expectNum)){
                return new int[]{numsMap.get(expectNum),i};
            }
            numsMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solutions");
    }

    @Test

    public void testTwoSum() {

        int[] testNums = new int[]{2, 7, 11, 15};
        int test1Target = 9;

        int[] result1 = new int[]{0, 1};


        assertEquals(Arrays.toString(result1), Arrays.toString(new Solution1().twoSum(testNums, test1Target)));


        int[] test2Nums = new int[]{3, 3};
        int test2Target = 6;

        int[] result2 = new int[]{0, 1};


        assertEquals(Arrays.toString(result2), Arrays.toString(new Solution1().twoSum(test2Nums, test2Target)));


    }


}
