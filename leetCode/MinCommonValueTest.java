package leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCommonValueTest {

    @Test
    void getCommonTest1() {
        int[] a= new int[]{1,2,3,6};
        int[] b= new int[]{1,13,14,15};
        int ans= MinCommonValue.getCommon(a,b);
        assertEquals(1,ans);
    }


    @Test
    void getCommonTest2() {
        int[] a= new int[]{1,2,3,6};
        int[] b= new int[]{2,3,4,5};
        int ans= MinCommonValue.getCommon(a,b);
        assertEquals(2,ans);
    }

    @Test
    void getCommonTest3() {
        int[] a= new int[]{1,2,3,100000000};
        int[] b= new int[]{4,5,100000000};
        int ans= MinCommonValue.getCommon(a,b);
        assertEquals(100000000,ans);
    }
    @Test
    void testBGreaterThanA() {
        int[] a= new int[]{1,2,3,100000000};
        int[] b= new int[]{4,5,6,100000000,2000000000};
        int ans= MinCommonValue.getCommon(a,b);
        assertEquals(100000000,ans);
    }
    @Test
    void testReturnNegative() {
        int[] a= new int[]{1,2,3,100000000};
        int[] b= new int[]{4,5,1000000000};
        int ans= MinCommonValue.getCommon(a,b);
        assertEquals(-1,ans);
    }
}