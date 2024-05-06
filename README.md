# DesignPattern


In the Simple Factory Pattern, where are the object creation details encapsulated?
In a single factory class


Which design pattern allows a class to delegate the responsibility of instantiating its objects to its subclasses?
Factory Method Pattern


What is the primary purpose of the Abstract Factory Design Pattern?
To provide an interface for creating families of related or dependent objects


In the Simple Factory Pattern, which component determines the type of object to be created?
Client code


## Builder Design Pattern

Create Object Step By Step (remembering order), optional parameter, 
Builder pattern helps making immuable object





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



##                 Singleton Design Pattern


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













































