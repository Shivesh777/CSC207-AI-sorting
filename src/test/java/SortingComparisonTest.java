import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingComparisonTest {

    private SortingComparison sortingComparison;

    @BeforeEach
    public void setUp() {
        SortingAlgorithm bubbleSortAlgorithm = new BubbleSort();
        SortingAlgorithm insertionSortAlgorithm = new InsertionSort();
        SortingAlgorithm mergeSortAlgorithm = new MergeSort();

        sortingComparison = new SortingComparison(bubbleSortAlgorithm, insertionSortAlgorithm, mergeSortAlgorithm);
    }

    @Test
    public void testSortingComparisonBubbleSort() {
        List<Integer> list = Arrays.asList(10, 3, 8, 5, 2, 7, 4, 1, 6, 9);
        SortingResult result = sortingComparison.performBubbleSort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result.getSortedList());
    }

    @Test
    public void testSortingComparisonInsertionSort() {
        List<Integer> list = Arrays.asList(10, 3, 8, 5, 2, 7, 4, 1, 6, 9);
        SortingResult result = sortingComparison.performInsertionSort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result.getSortedList());
    }

    @Test
    public void testSortingComparisonMergeSort() {
        List<Integer> list = Arrays.asList(10, 3, 8, 5, 2, 7, 4, 1, 6, 9);
        SortingResult result = sortingComparison.performMergeSort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result.getSortedList());
    }
}
