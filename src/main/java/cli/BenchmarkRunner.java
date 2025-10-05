package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        System.out.println("Heap Sort Benchmark Runner");

        int[] sizes = {100, 1000, 10000};

        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            writer.write("size,comparisons,swaps,array_accesses,time_nano\n");

            for (int size : sizes) {
                System.out.println("Testing size: " + size);

                int[] array = generateRandomArray(size);

                HeapSort sorter = new HeapSort();
                sorter.sort(array);

                PerformanceTracker tracker = sorter.getTracker();

                String line = String.format("%d,%d,%d,%d,%d\n",
                        size, tracker.getComparisons(), tracker.getSwaps(),
                        tracker.getArrayAccesses(), tracker.getTimeNano());
                writer.write(line);

                System.out.printf("Comparisons: %,d\n", tracker.getComparisons());
                System.out.printf("Time: %,d ns\n", tracker.getTimeNano());

                if (!HeapSort.isSorted(array)) {
                    System.err.println("ERROR: Array not sorted!");
                }
            }

            System.out.println("Benchmark completed. Results saved to benchmark_results.csv");

        } catch (IOException e) {
            System.err.println("Error writing results: " + e.getMessage());
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random(42);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }
}