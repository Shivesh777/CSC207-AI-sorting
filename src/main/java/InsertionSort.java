import java.util.ArrayList;
import java.util.List;

/**
 * InsertionSort implements the SortingAlgorithm interface and provides the Insertion Sort algorithm.
 */
public class InsertionSort implements SortingAlgorithm {
    private int recursiveCallCount;

    @Override
    public SortingResult sort(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        recursiveCallCount = 0;
        long startTime = System.nanoTime();

        // Implementation of insertion sort
        int n = sortedList.size();
        for (int i = 1; i < n; i++) {
            int key = sortedList.get(i);
            int j = i - 1;

            while (j >= 0 && sortedList.get(j) > key) {
                recursiveCallCount++;
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, key);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000; // Convert to microseconds

        return new SortingResult(sortedList, duration);
    }

    @Override
    public int getRecursiveCallCount() {
        return recursiveCallCount;
    }
}
