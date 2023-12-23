import java.util.ArrayList;
import java.util.List;

/**
 * MergeSort implements the SortingAlgorithm interface and provides the Merge Sort algorithm.
 */
public class MergeSort implements SortingAlgorithm {
    private int recursiveCallCount;

    @Override
    public SortingResult sort(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        recursiveCallCount = 0;
        long startTime = System.nanoTime();

        // Implementation of merge sort
        mergeSort(sortedList, 0, sortedList.size() - 1);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000; // Convert to microseconds

        return new SortingResult(sortedList, duration);
    }

    /**
     * Recursive method to perform merge sort on the list.
     *
     * @param list  the list to be sorted.
     * @param left  the left index of the sublist.
     * @param right the right index of the sublist.
     */
    private void mergeSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    /**
     * Merges two sorted sublists into a single sorted list.
     *
     * @param list  the list containing the elements to be merged.
     * @param left  the left index of the left sublist.
     * @param mid   the middle index of the two sublists.
     * @param right the right index of the right sublist.
     */
    private void merge(List<Integer> list, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        List<Integer> leftTemp = new ArrayList<>();
        List<Integer> rightTemp = new ArrayList<>();

        // Copy data to temporary lists
        for (int i = 0; i < leftSize; i++) {
            leftTemp.add(list.get(left + i));
        }
        for (int j = 0; j < rightSize; j++) {
            rightTemp.add(list.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;

        // Merge the temporary lists back into the original list
        while (i < leftSize && j < rightSize) {
            recursiveCallCount++;
            if (leftTemp.get(i) <= rightTemp.get(j)) {
                list.set(k, leftTemp.get(i));
                i++;
            } else {
                list.set(k, rightTemp.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftTemp and rightTemp (if any)
        while (i < leftSize) {
            recursiveCallCount++;
            list.set(k, leftTemp.get(i));
            i++;
            k++;
        }

        while (j < rightSize) {
            recursiveCallCount++;
            list.set(k, rightTemp.get(j));
            j++;
            k++;
        }
    }

    @Override
    public int getRecursiveCallCount() {
        return recursiveCallCount;
    }
}
