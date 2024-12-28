# DesignPattern


##                 Creational Design Pattern

##                 Structural Design Pattern

* Add New functionality without modifying the entire system.
* Focus on structuring the object,classes
* This pattern help us in organize objects and classes for better scalability, reusability and flexibility


##                  Behavioral Design Pattern


This document provides a categorized list of common design patterns, their definitions, and use cases.

| **Design Pattern**            | **Definition**                                                               | **Category**   | **Use Cases**                                                                                     |
|-------------------------------|------------------------------------------------------------------------------|----------------|--------------------------------------------------------------------------------------------------|
| **Singleton**                 | Ensures a class has only one instance and provides a global point of access. | Creational     | Logging service, configuration managers, database connection pools.                             |
| **Factory Method**            | Defines an interface for creating an object, allowing subclasses to decide.  | Creational     | Document readers (e.g., creating `PDFReader` or `WordReader` based on input file type).          |
| **Abstract Factory**          | Creates families of related or dependent objects without specifying classes. | Creational     | GUI toolkits (e.g., creating buttons and text boxes for different operating systems).            |
| **Builder**                   | Separates object construction from representation.                           | Creational     | Constructing complex objects like `Car`, `House`, or `HttpRequest` with step-by-step assembly.   |
| **Prototype**                 | Creates new objects by copying an existing one.                              | Creational     | Cloning shapes in a graphic editor or creating objects in gaming environments.                   |
| **Object Pool**               | Manages a pool of reusable objects to improve resource use.                  | Creational     | Database connections, thread pools, or reusable buffer objects.                                 |
| **Adapter**                   | Converts a class's interface into another interface expected by the client.  | Structural     | Integrating legacy code with a modern system, connecting APIs with mismatched interfaces.        |
| **Bridge**                    | Decouples abstraction from implementation so they can vary independently.    | Structural     | Implementing cross-platform UI components or separating device and rendering logic in graphics.  |
| **Composite**                 | Composes objects into tree structures to represent part-whole hierarchies.   | Structural     | File systems (folders and files), organizational hierarchies, or UI menu structures.             |
| **Decorator**                 | Dynamically adds responsibilities to objects.                                | Structural     | Adding functionalities to a `FileStream` (e.g., compression, encryption).                       |
| **Facade**                    | Provides a simplified interface to a complex subsystem.                      | Structural     | Simplifying access to subsystems like media players, database libraries, or payment gateways.    |
| **Flyweight**                 | Minimizes memory use by sharing data among similar objects.                  | Structural     | Rendering text in word processors, managing objects in games like trees in a forest scene.       |
| **Proxy**                     | Provides a placeholder to control access to another object.                  | Structural     | Lazy initialization, access control, or implementing network proxies.                           |
| **Chain of Responsibility**   | Passes a request along a chain of handlers until one handles it.             | Behavioral     | Logging frameworks, approval workflows, or request handling in web servers.                     |
| **Command**                   | Encapsulates a request as an object.                                         | Behavioral     | Implementing undo/redo functionality in text editors or managing remote controls.                |
| **Interpreter**               | Defines a grammar and an interpreter for a language.                         | Behavioral     | Mathematical expression evaluators or scripting language interpreters.                           |
| **Iterator**                  | Provides a way to access elements sequentially without exposing structure.   | Behavioral     | Traversing collections like arrays, lists, or trees without exposing their internal structure.   |
| **Mediator**                  | Encapsulates how objects interact.                                           | Behavioral     | Managing communication in chat applications or centralizing UI component interaction.            |
| **Memento**                   | Captures and restores an object’s state without breaking encapsulation.      | Behavioral     | Saving and restoring game progress or implementing undo in text editors.                         |
| **Observer**                  | Establishes a one-to-many dependency for state changes.                      | Behavioral     | Event-driven systems like stock price trackers or notification systems.                          |
| **State**                     | Alters an object’s behavior when its state changes.                          | Behavioral     | Implementing state machines for ATMs, traffic lights, or game character behaviors.               |
| **Strategy**                  | Encapsulates interchangeable algorithms.                                     | Behavioral     | Sorting strategies (e.g., quicksort or mergesort), payment methods in e-commerce systems.        |
| **Template Method**           | Defines the structure of an algorithm, deferring steps to subclasses.        | Behavioral     | Frameworks like Spring’s lifecycle methods or defining workflow for report generation.           |
| **Visitor**                   | Represents an operation to be performed on object elements.                  | Behavioral     | Operations on file systems (e.g., size calculation or searching) or syntax tree traversal.       |

---

### Code Examples
For code implementations of these patterns, refer to the respective directories in the repository.



####               MCQ




1. In the Simple Factory Pattern, where are the object creation details encapsulated?
In a single factory class

2. Which design pattern allows a class to delegate the responsibility of instantiating its objects to its subclasses?
Factory Method Pattern

3. What is the primary purpose of the Abstract Factory Design Pattern?
To provide an interface for creating families of related or dependent objects

4. In the Simple Factory Pattern, which component determines the type of object to be created?
Client code




##                Builder Design Pattern: Creational 

Create Object Step By Step (remembering order), optional parameter, 
Builder pattern helps making immuable object






##                 Iterator Design Pattern

Providing a uniform way to traverse collections without exposing their underlying structure and implementation.

### Key Components

1. Iterator - Defines common iterface for iterating elements
2. Concrete Iterator - Implements the iterator interface for specific collection.
3. Aggregator - Defines an interface for creating an iterator
4. Concrete Aggregator - Implements the aggregrate interface and provides an iterator for its elements.

### Advantages

1. Decouping: Seprate Collection traversal from its internal structure 
2. Uniform Interface: Provides a way consistent way to access elements in various collections
3. Iteration Control: Allows itertion control (forward, backward) without changing collection code


### Disadvantages

1. Complexity: Introducing iterators can make the code more complex.
2. Overhead: May create overhead when creating iterator objects
3. Not Suitable For All Collection: May not be practical for small or simple collections


### Examples

1. File Systems: Iterating files and directories in a file system.
2. Menu Systems: Iterating through menu items in user interface
3. Text Processing: Scanning words or charcters in a text document.
4. Playlist Management: Managing song playlist in music players



##                 Singleton Design Pattern: Creational 


* Ensuring a class has only one instance and providing a global point of access to that instance
* Useful where there is exactly one object needed throughout your application.


### Key Componenets

* Private Constructor: Restricts direct object creation
* Private Static Instance: Holds the unique instance.
* Public static Method (Getter): Provides access to the instance


### Advantages

* Single instance ensures that only one instance of the class exists throughout the applications lifetime.
* Global access providers a centralized point for accessing the instance, facilating easy communication

### Disadvantages

* Global State: Can introduce global state, affecting testability
* Limited Extensibilty: Hard to subclass, or mock for testing
* Violates Single Responsibilty Principle: Combines instance management with class logic

### Early/Eager and Late Intialization:

* Early/Eager intialization: Involves creating the singleton instance at the same time the class is loaded or during application startup. It ensures that the instance is always available but may consume 
resources even if not needed immediately
* Eager Initialization: The singleton instance will be created as soon as the class loader loads the class into memory. 
* In eager initialization of the singleton pattern, the instance of the singleton class is created at the time of class loading. This ensures that the instance is always available and thread-safe. However, there can be potential issues with eager initialization when multiple threads access the singleton instance simultaneously.




* Late Intialization: In Late intialization, the singleton instance is created when it first requested.
This conserves resources and often used for scenarios where creation of object is costly, and it is desirable to delay it until necessary.


### Double Checked Locking:

* Double checked locking is a synchronization mechanism used in mutithreaded environments to improve the performance of lazy intialization of a singleton.

* It is needed to prevent the overhead of acquring lock everytime a thread checks . if instance is intialized with double checked locking, a lock is acquired only when the instance is not already intialized, reducing contention among threads.


### Examples:

* Logging: Centralized logging across the application
* Database Connection Pool: Managing shared database connections.
* Caching: Maintaing a single cache instance
* Configuration Management: Global application management.
* Thread Pools: Manging a limited set of worker threads
* Device Drivers: Ensuring one instance hardware control
* Resource Managers: Controlling access to resource like: file systems 



##                  Decorator Design Pattern: Structural 



* The Decorator Pattern allows adding behavior to an object dynamically, without modifying its structure.
* It’s like customizing chai. You start with basic chai and then add ingredients (ginger, cardamom) as needed, without changing the original recipe.
* The pattern allows you to add features dynamically without altering the core logic.
* Code Reusability: You can reuse the basic chai and create different variations without duplicating code.
* Scalability: You can keep adding new types of chai by introducing new decorators without changing existing ones.



##                 Observer Design Pattern

##                 Iterator Design Pattern

Providing a uniform way to traverse collections without exposing their underlying structure and implementation.

### Key Components

1. Iterator - Defines common iterface for iterating elements
2. Concrete Iterator - Implements the iterator interface for specific collection.
3. Aggregator - Defines an interface for creating an iterator
4. Concrete Aggregator - Implements the aggregrate interface and provides an iterator for its elements.

### Advantages

1. Decouping: Seprate Collection traversal from its internal structure
2. Uniform Interface: Provides a way consistent way to access elements in various collections
3. Iteration Control: Allows itertion control (forward, backward) without changing collection code


### Disadvantages

1. Complexity: Introducing iterators can make the code more complex.
2. Overhead: May create overhead when creating iterator objects
3. Not Suitable For All Collection: May not be practical for small or simple collections


### Examples

1. File Systems: Iterating files and directories in a file system.
2. Menu Systems: Iterating through menu items in user interface
3. Text Processing: Scanning words or charcters in a text document.
4. Playlist Management: Managing song playlist in music players






















































































