
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



