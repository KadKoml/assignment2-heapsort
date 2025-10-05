package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeCaseTest {

    @Test
    void testEmptyArray() {
        HeapSort sorter = new HeapSort();
        int[] array = {};
        sorter.sort(array);
        assertTrue(HeapSort.isSorted(array));
    }

    @Test
    void testSingleElement() {
        HeapSort sorter = new HeapSort();
        int[] array = {5};
        sorter.sort(array);
        assertTrue(HeapSort.isSorted(array));
        assertEquals(5, array[0]);
    }

    @Test
    void testArrayWithAllSameElements() {
        HeapSort sorter = new HeapSort();
        int[] array = {3, 3, 3, 3, 3};
        sorter.sort(array);
        assertTrue(HeapSort.isSorted(array));
    }

    @Test
    void testArrayWithNegativeNumbers() {
        HeapSort sorter = new HeapSort();
        int[] array = {-5, -1, -3, -2, -4};
        sorter.sort(array);
        assertTrue(HeapSort.isSorted(array));
    }

    @Test
    void testOptimizedEmptyArray() {
        HeapSort sorter = new HeapSort();
        int[] array = {};
        sorter.sortOptimized(array);
        assertTrue(HeapSort.isSorted(array));
    }

    @Test
    void testOptimizedSingleElement() {
        HeapSort sorter = new HeapSort();
        int[] array = {5};
        sorter.sortOptimized(array);
        assertTrue(HeapSort.isSorted(array));
        assertEquals(5, array[0]);
    }
}