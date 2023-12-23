import java.util.List;

/**
 * The SortingAlgorithm interface defines the contract for all sorting algorithms.
 */
public interface SortingAlgorithm {

    /**
     * Sorts a list of integers using the specific sorting algorithm.
     *
     * @param list the list of integers to be sorted.
     * @return a {@link SortingResult} object containing the sorted list and the runtime.
     */
    SortingResult sort(List<Integer> list);

    /**
     * Returns the number of recursive calls made during the sorting operation.
     *
     * @return the number of recursive calls.
     */
    int getRecursiveCallCount();
}
