import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The ConsoleUserInterface class provides an interactive command-line interface for the sorting algorithm comparison.
 */
public class ConsoleUserInterface {
    private final SortingService sortingService;

    public ConsoleUserInterface(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    /**
     * Starts the sorting algorithm comparison program, allowing the user to select options and input lists for sorting.
     */
    public void startSorting() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list;

        System.out.println("Select an option:");
        System.out.println("1. Generate a random list");
        System.out.println("2. Enter your own list");
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.print("Enter the size of the random list: ");
            int size = scanner.nextInt();
            list = generateRandomList(size);
        } else if (option == 2) {
            System.out.println("Enter your list of integers separated by spaces:");
            scanner.nextLine(); // Consume the newline character
            String input = scanner.nextLine();
            list = parseCustomList(input);
        } else {
            System.out.println("Invalid option. Exiting.");
            return;
        }

        SortingResult resultBubbleSort = sortingService.performBubbleSort(list);
        SortingResult resultInsertionSort = sortingService.performInsertionSort(list);
        SortingResult resultMergeSort = sortingService.performMergeSort(list);

        System.out.println("\nOriginal List:");
        printList(list);

        System.out.println("\nBubble Sort - Sorted List:");
        printList(resultBubbleSort.getSortedList());
        System.out.println("Bubble Sort - Sorting Runtime: " + resultBubbleSort.getRuntime() + " microseconds");
        System.out.println("Bubble Sort - Number of Recursive Calls: " + sortingService.getRecursiveCallCountBubbleSort());

        System.out.println("\nInsertion Sort - Sorted List:");
        printList(resultInsertionSort.getSortedList());
        System.out.println("Insertion Sort - Sorting Runtime: " + resultInsertionSort.getRuntime() + " microseconds");
        System.out.println("Insertion Sort - Number of Recursive Calls: " + sortingService.getRecursiveCallCountInsertionSort());

        System.out.println("\nMerge Sort - Sorted List:");
        printList(resultMergeSort.getSortedList());
        System.out.println("Merge Sort - Sorting Runtime: " + resultMergeSort.getRuntime() + " microseconds");
        System.out.println("Merge Sort - Number of Recursive Calls: " + sortingService.getRecursiveCallCountMergeSort());

        String fastestAlgorithm = getFastestAlgorithm(resultBubbleSort, resultInsertionSort, resultMergeSort);
        System.out.println("\nVerdict: " + fastestAlgorithm + " is the fastest sorting algorithm.");

    }

    private List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 100)); // Random integers between 0 and 99
        }
        return list;
    }

    private List<Integer> parseCustomList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = input.trim().split("\\s+");
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                list.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + number + ". Skipping...");
            }
        }
        return list;
    }

    private void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private String getFastestAlgorithm(SortingResult resultBubbleSort, SortingResult resultInsertionSort, SortingResult resultMergeSort) {
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
