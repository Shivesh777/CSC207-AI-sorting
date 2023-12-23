import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertionSortTest {

    @Test
    public void testInsertionSortEmptyList() {
        List<Integer> list = new ArrayList<>();
        SortingAlgorithm insertionSort = new InsertionSort();
        SortingResult result = insertionSort.sort(list);
        assertTrue(result.getSortedList().isEmpty());
    }

    @Test
    public void testInsertionSortAlreadySorted() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        SortingAlgorithm insertionSort = new InsertionSort();
        SortingResult result = insertionSort.sort(list);
        assertEquals(list, result.getSortedList());
    }

    @Test
    public void testInsertionSortReverseSorted() {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        SortingAlgorithm insertionSort = new InsertionSort();
        SortingResult result = insertionSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result.getSortedList());
    }

    @Test
    public void testInsertionSortRandomList() {
        List<Integer> list = Arrays.asList(10, 3, 8, 5, 2, 7, 4, 1, 6, 9);
        SortingAlgorithm insertionSort = new InsertionSort();
        SortingResult result = insertionSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result.getSortedList());
    }

    @Test
    public void testInsertionSortDuplicateElements() {
        List<Integer> list = Arrays.asList(5, 2, 4, 3, 5, 1);
        SortingAlgorithm insertionSort = new InsertionSort();
        SortingResult result = insertionSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 5), result.getSortedList());
    }
}
