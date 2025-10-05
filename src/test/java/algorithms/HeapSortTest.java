package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

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
    void testAlreadySorted() {
        HeapSort sorter = new HeapSort();
        int[] array = {1, 2, 3, 4, 5};
        sorter.sort(array);
        assertTrue(HeapSort.isSorted(array));
    }

    @Test
    void testReverseSorted() {
        HeapSort sorter = new HeapSort();
        int[] array = {5, 4, 3, 2, 1};
        sorter.sort(array);
        assertTrue(HeapSort.isSorted(array));
    }

    @Test
    void testArrayWithDuplicates() {
        HeapSort sorter = new HeapSort();
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        sorter.sort(array);
        assertTrue(HeapSort.isSorted(array));
    }

    @Test
    void testNullArray() {
        HeapSort sorter = new HeapSort();
        assertThrows(IllegalArgumentException.class,
                () -> sorter.sort(null));
    }
}