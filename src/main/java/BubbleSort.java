import java.util.ArrayList;
import java.util.List;

/**
 * BubbleSort implements the SortingAlgorithm interface and provides the Bubble Sort algorithm.
 */
public class BubbleSort implements SortingAlgorithm {
    private int recursiveCallCount;

    @Override
    public SortingResult sort(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        recursiveCallCount = 0;
        long startTime = System.nanoTime();

        // Implementation of bubble sort
        int n = sortedList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                recursiveCallCount++;
                if (sortedList.get(j) > sortedList.get(j + 1)) {
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
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
