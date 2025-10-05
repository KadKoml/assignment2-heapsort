package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {
    private PerformanceTracker tracker;

    public HeapSort() {
        this.tracker = new PerformanceTracker();
    }

    public PerformanceTracker getTracker() {
        return tracker;
    }

    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (array.length <= 1) {
            return;
        }

        tracker.reset();
        tracker.startTimer();

        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Swap root with last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            tracker.incrementSwaps();
            tracker.incrementArrayAccesses(4);

            heapify(array, i, 0);
        }

        tracker.stopTimer();
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            tracker.incrementComparisons();
            tracker.incrementArrayAccesses(2);
            if (array[left] > array[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            tracker.incrementComparisons();
            tracker.incrementArrayAccesses(2);
            if (array[right] > array[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            tracker.incrementSwaps();
            tracker.incrementArrayAccesses(4);


            heapify(array, n, largest);
        }
    }
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}