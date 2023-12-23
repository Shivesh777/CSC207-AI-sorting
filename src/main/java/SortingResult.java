import java.util.List;

/**
 * The SortingResult class represents the result of a sorting operation, containing the sorted list and the runtime.
 */
public class SortingResult {
    private final List<Integer> sortedList;
    private final long runtime;

    public SortingResult(List<Integer> sortedList, long runtime) {
        this.sortedList = sortedList;
        this.runtime = runtime;
    }

    /**
     * Gets the sorted list after the sorting operation.
     *
     * @return the sorted list.
     */
    public List<Integer> getSortedList() {
        return sortedList;
    }

    /**
     * Gets the runtime of the sorting operation in microseconds.
     *
     * @return the runtime in microseconds.
     */
    public long getRuntime() {
        return runtime;
    }
}
