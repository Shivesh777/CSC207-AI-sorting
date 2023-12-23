public class App {
    public static void main(String[] args) {
        SortingAlgorithm bubbleSortAlgorithm = new BubbleSort();
        SortingAlgorithm insertionSortAlgorithm = new InsertionSort();
        SortingAlgorithm mergeSortAlgorithm = new MergeSort();

        SortingService sortingService = new SortingComparison(bubbleSortAlgorithm, insertionSortAlgorithm, mergeSortAlgorithm);
        ConsoleUserInterface userInterface = new ConsoleUserInterface(sortingService);
        userInterface.startSorting();
    }
}
