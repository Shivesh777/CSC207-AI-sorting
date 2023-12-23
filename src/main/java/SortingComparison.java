import java.util.List;

/**
 * The SortingComparison class implements the SortingService interface and acts as a coordinator for the sorting algorithms.
 */
public class SortingComparison implements SortingService {
    private final SortingAlgorithm bubbleSortAlgorithm;
    private final SortingAlgorithm insertionSortAlgorithm;
    private final SortingAlgorithm mergeSortAlgorithm;

    public SortingComparison(SortingAlgorithm bubbleSortAlgorithm, SortingAlgorithm insertionSortAlgorithm, SortingAlgorithm mergeSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
        this.insertionSortAlgorithm = insertionSortAlgorithm;
        this.mergeSortAlgorithm = mergeSortAlgorithm;
    }

    @Override
    public SortingResult performBubbleSort(List<Integer> list) {
        return bubbleSortAlgorithm.sort(list);
    }

    @Override
    public SortingResult performInsertionSort(List<Integer> list) {
        return insertionSortAlgorithm.sort(list);
    }

    @Override
    public SortingResult performMergeSort(List<Integer> list) {
        return mergeSortAlgorithm.sort(list);
    }

    @Override
    public int getRecursiveCallCountBubbleSort() {
        return bubbleSortAlgorithm.getRecursiveCallCount();
    }

    @Override
    public int getRecursiveCallCountInsertionSort() {
        return insertionSortAlgorithm.getRecursiveCallCount();
    }

    @Override
    public int getRecursiveCallCountMergeSort() {
        return mergeSortAlgorithm.getRecursiveCallCount();
    }

    public String getFastestAlgorithm(SortingResult resultBubbleSort, SortingResult resultInsertionSort, SortingResult resultMergeSort) {
        long minRuntime = Math.min(Math.min(resultBubbleSort.getRuntime(), resultInsertionSort.getRuntime()), resultMergeSort.getRuntime());
        if (minRuntime == resultBubbleSort.getRuntime()) {
            return "Bubble Sort";
        } else if (minRuntime == resultInsertionSort.getRuntime()) {
            return "Insertion Sort";
        } else {
            return "Merge Sort";
        }
    }
}
