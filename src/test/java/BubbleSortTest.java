import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BubbleSortTest {

    @Test
    public void testBubbleSortEmptyList() {
        List<Integer> list = new ArrayList<>();
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingResult result = bubbleSort.sort(list);
        assertTrue(result.getSortedList().isEmpty());
    }

    @Test
    public void testBubbleSortAlreadySorted() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingResult result = bubbleSort.sort(list);
        assertEquals(list, result.getSortedList());
    }

    @Test
    public void testBubbleSortReverseSorted() {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingResult result = bubbleSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result.getSortedList());
    }

    @Test
    public void testBubbleSortRandomList() {
        List<Integer> list = Arrays.asList(10, 3, 8, 5, 2, 7, 4, 1, 6, 9);
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingResult result = bubbleSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result.getSortedList());
    }

    @Test
    public void testBubbleSortDuplicateElements() {
        List<Integer> list = Arrays.asList(5, 2, 4, 3, 5, 1);
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingResult result = bubbleSort.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 5), result.getSortedList());
    }
}
