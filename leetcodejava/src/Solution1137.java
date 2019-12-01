import org.junit.Test;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution1137 {

    public int tribonacci(int n) {
/*
        if(n == 0){
            return 0;
        }
        if( n==1 || n==2){
            return 1;
        }

        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);*/

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int result = 0;
        for (int i = 0; i < n-2; i++) {
            result = a + b + c;
            a = b;
            b = c;
            c = result;
        }
        return result;
    }

    @Test

    public void testTribonacci() {

        int test1Nums = 4;
        int result1 = 4;


        assertEquals(result1, tribonacci(test1Nums));


        int test2Nums = 25;
        int result2 = 1389537;


        assertEquals(result2, tribonacci(test2Nums));


    }
}
