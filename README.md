# Java Sorting Program

## Summary

This Java program implements various sorting algorithms, including Bubble Sort, Insertion Sort, and Merge Sort, and allows users to interact with the program through the terminal. The program prompts the user to either generate a random list of numbers or provide a list of integers. Then, it performs all the sorting algorithms on the input list and compares their runtimes to determine the fastest sorting algorithm. The program displays the sorted lists, the time taken for each algorithm, the number of recursive calls made, and the verdict on the fastest algorithm.

## Java Version and Testing Framework

The program is implemented in Java and requires at least Java 8 to run. It uses JUnit 5 as the testing framework for unit testing the sorting algorithms and other program components.

## Use Cases

1. User wants to generate a random list and compare different sorting algorithms to find the fastest one.
2. User wants to provide a custom list of integers and see how each sorting algorithm performs on the input.
3. User wants to determine the efficiency of the sorting algorithms in terms of runtime and recursive calls.

## User Story

As a software developer, I want to use a Java program that can efficiently compare the runtime performance of different sorting algorithms, including Bubble Sort, Insertion Sort, and Merge Sort. This will help me make informed decisions about which sorting algorithm to use in my applications. I expect the program to provide accurate and detailed information about each sorting algorithm's execution time and recursive calls. Additionally, I would like the program to support both custom input lists and randomly generated lists so that I can test various use cases effectively.

The Java Sorting Program should have a user-friendly terminal interface that guides me through the process of selecting the sorting algorithms and input method. Once the sorting is complete, the program should display the sorted lists, the time taken for each algorithm, and the verdict on the fastest algorithm based on actual runtime performance.

The program should adhere to clean architecture principles, using the Strategy Pattern to allow for easy addition of new sorting algorithms in the future without modifying existing code. Dependency Injection should be utilized to manage the sorting algorithm dependencies, ensuring flexibility and reducing coupling between components.

I expect the program to be modular, well-documented with JavaDocs, and accompanied by extensive test files to verify the correctness of sorting algorithms and handle edge cases appropriately. The README should provide clear instructions on how to run the program, interpret the results, and understand the design choices made.

By using this Java Sorting Program, I aim to streamline my sorting algorithm selection process, optimize the performance of my applications, and maintain a codebase that is easy to understand and maintain.

## Design Patterns

The program implements two essential design patterns to achieve flexibility and maintainability:

### Strategy Pattern <sub><sup>(Cited here: [java-design-patterns.com/patterns/strategy/](https://java-design-patterns.com/patterns/strategy/))</sup></sub>

The Strategy Pattern is employed in the implementation of sorting algorithms. The `SortingAlgorithm` interface acts as the strategy, providing a common contract for various sorting algorithms. Concrete implementations of this interface (Bubble Sort, Insertion Sort, Merge Sort) encapsulate individual sorting algorithms. This pattern allows the program to dynamically switch between sorting algorithms at runtime based on user input or requirements.

### Dependency Injection <sub><sup>(Cited here: [java-design-patterns.com/patterns/dependency-injection/](https://java-design-patterns.com/patterns/dependency-injection/))</sup></sub>

The program follows the Dependency Inversion Principle by using Dependency Injection to manage the sorting algorithms' dependencies. In the `SortingComparison` class, the sorting algorithms (Bubble Sort, Insertion Sort, Merge Sort) are injected as constructor dependencies, reducing tight coupling and making the class more extensible. This approach allows for easy addition of new sorting algorithms without modifying the core logic of the `SortingComparison` class.

## SOLID Compliance

The Java Sorting Program has been designed with adherence to the SOLID principles, which are fundamental principles of object-oriented design that promote maintainability, flexibility, and robustness of the codebase.

### Single Responsibility Principle (SRP)

Each class in the program has a single responsibility, ensuring that they are focused on specific tasks. The `SortingAlgorithm` interface defines a common contract for sorting algorithms, and the `SortingService` interface provides a common contract for the sorting service. Concrete implementations of these interfaces encapsulate individual sorting algorithms and the sorting service logic, respectively.

### Open/Closed Principle (OCP)

The program follows the Open/Closed Principle by allowing easy extension without modification of existing code. New sorting algorithms can be added by implementing the `SortingAlgorithm` interface, and the sorting service can accommodate these new algorithms without any changes.

### Liskov Substitution Principle (LSP)

The Liskov Substitution Principle is adhered to in the program by ensuring that the concrete implementations of the `SortingAlgorithm` interface can be substituted for the base interface without affecting the correctness of the program's behavior. Each sorting algorithm implementation correctly adheres to the expected contract.

### Interface Segregation Principle (ISP)

The program applies the Interface Segregation Principle by defining the `SortingAlgorithm` interface with only the necessary methods for sorting. This allows clients to implement specific sorting algorithms without being forced to provide unnecessary methods.

### Dependency Inversion Principle (DIP)

The program follows the Dependency Inversion Principle through Dependency Injection. The `SortingComparison` class depends on the `SortingService` interface, and the `SortingService` interface, in turn, depends on the `SortingAlgorithm` interface. This allows for loose coupling between components and promotes flexibility in selecting different sorting algorithms at runtime.

## Clean Architecture Compliance

The Java Sorting Program is designed following Clean Architecture principles, promoting a clear separation of concerns and a highly maintainable codebase.

The program adheres to the following architectural layers:

### Entities

The `SortingAlgorithm` interface represents the entities of the sorting algorithms. It encapsulates the sorting logic without being influenced by external concerns.

### Use Cases

The `SortingService` interface and its concrete implementations serve as the use case layer, which orchestrates the sorting algorithms' comparison and the display of results. It is independent of the data sources and external frameworks.

### Interface Adapters

The `ConsoleUserInterface` class is considered an interface adapter in this program. It bridges the gap between the use case layer and the external world, allowing user interaction through the terminal.

### Frameworks & Drivers

JUnit 5 is utilized as the testing framework, serving as an external driver to validate the correctness of sorting algorithms.

## Code Smells Avoided

During the development of the Java Sorting Program, several code smells were identified and addressed to maintain a high-quality codebase:

- **Duplicated Code:** Code duplication was minimized by extracting common functionality into reusable methods and promoting code reusability.

- **Large Classes/Methods:** Classes and methods were kept concise and focused on specific tasks, adhering to the single responsibility principle.

- **Inappropriate Comments:** Clear and concise comments were added where necessary to enhance code readability, while unnecessary or misleading comments were removed.

- **Long Parameter Lists:** The number of parameters in methods was minimized, and objects were used to encapsulate related data.

- **Tight Coupling:** Dependency Injection was applied to manage dependencies and promote loose coupling between components.

## Code Smells and SOLID/CA Violations

The code has been refactored to improve adherence to SOLID principles and Clean Architecture. It now follows the Dependency Inversion Principle by using interfaces for the sorting algorithms. Additionally, the program uses composition over inheritance for the sorting strategies. However, some potential areas of improvement include:
- **High Coupling:** While the program is relatively modular, there is still some coupling between the `SortingComparison` and the sorting algorithms. Dependency Injection can further decouple these components.
- **Magic Numbers:** The `generateLargeRandomList` method in the test class uses a magic number for the list size. It could be better to make this size configurable or parameterized.
- **Lack of Abstraction:** The program only supports integer lists. Adding generic support for different data types could improve flexibility.

Overall, the program has improved in terms of adhering to clean architecture principles and SOLID design principles, but there is room for further improvement. Regular refactoring and code reviews can help address these code smells and maintain a high-quality codebase.