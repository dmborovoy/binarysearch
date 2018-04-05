package org.cardpay.search;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @BeforeMethod
    public void setUp() throws Exception {
        binarySearch = new BinarySearchImpl();
    }

    @DataProvider(name = "positive_data")
    public static Object[][] positiveData() {
        return new Object[][]{
                {new DataHolder(new int[]{1, 2, 3, 4, 5, 6, 7}, 1, 0)},
                {new DataHolder(new int[]{1, 2, 3, 4, 5, 6, 7}, 7, 6)},
                {new DataHolder(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, 2)},
                {new DataHolder(new int[]{-7, -6, -5, -4, -3, -2, -1}, -7, 0)},
                {new DataHolder(new int[]{-7, -6, -5, -4, -3, -2, -1}, -1, 6)},
                {new DataHolder(new int[]{-7, -6, -5, -4, -3, -2, -1}, -5, 2)},
                {new DataHolder(new int[]{1}, 1, 0)},
                {new DataHolder(new int[]{1, 2}, 2, 1)}
        };
    }

    @DataProvider(name = "negative_data")
    public static Object[][] negativeData() {
        return new Object[][]{
                {new DataHolder(new int[]{1}, 2, -1)},
                {new DataHolder(new int[]{1, 3, 4, 5, 6, 7}, 2, -1)},
                {new DataHolder(new int[]{1, 2, 3, 4, 5, 6, 7}, -1, -1)},
                {new DataHolder(new int[]{-7, -5, -4, -3, -2, -1}, -6, -1)},
                {new DataHolder(new int[]{}, 0, -1)}
        };
    }


    @Test(dataProvider = "positive_data")
    public void testPositive(DataHolder dataHolder) throws Exception {
        assertEquals(binarySearch.binSearch(dataHolder.getArr(), dataHolder.getVal()), dataHolder.getExpectedIdx());
    }

    @Test(dataProvider = "negative_data")
    public void testNegative(DataHolder dataHolder) throws Exception {
        assertEquals(binarySearch.binSearch(dataHolder.getArr(), dataHolder.getVal()), dataHolder.getExpectedIdx());
    }
}
