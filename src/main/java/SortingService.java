import java.util.List;

/**
 * The SortingService interface defines the contract for performing sorting operations.
 */
public interface SortingService {

    /**
     * Performs the Bubble Sort on the given list of integers.
     *
     * @param list the list of integers to be sorted.
     * @return a {@link SortingResult} object containing the sorted list and the runtime.
     */
    SortingResult performBubbleSort(List<Integer> list);

    /**
     * Performs the Insertion Sort on the given list of integers.
     *
     * @param list the list of integers to be sorted.
     * @return a {@link SortingResult} object containing the sorted list and the runtime.
     */
    SortingResult performInsertionSort(List<Integer> list);

    /**
     * Performs the Merge Sort on the given list of integers.
     *
     * @param list the list of integers to be sorted.
     * @return a {@link SortingResult} object containing the sorted list and the runtime.
     */
    SortingResult performMergeSort(List<Integer> list);

    /**
     * Returns the number of recursive calls made during the Bubble Sort.
     *
     * @return the number of recursive calls for Bubble Sort.
     */
    int getRecursiveCallCountBubbleSort();

    /**
     * Returns the number of recursive calls made during the Insertion Sort.
     *
     * @return the number of recursive calls for Insertion Sort.
     */
    int getRecursiveCallCountInsertionSort();

    /**
     * Returns the number of recursive calls made during the Merge Sort.
     *
     * @return the number of recursive calls for Merge Sort.
     */
    int getRecursiveCallCountMergeSort();
}
