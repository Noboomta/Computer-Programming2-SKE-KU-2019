## Programming Problems Using Anonymous Class and Method Reference

1. In `Main.main` assign `compByCurrency` to an **anonymous class** that implements `Comparator<Valuable>` (**TODO 1**).  The anonymous class contains exactly the same code as the CurrencyComparator class.

2. In `Main` write a static method named `compareByCurrency` that does the same thing as the method in the CurrencyComparator class (you can copy the code).  Then,  in **TODO 2** write a method reference to this method.  Like magic, `Arrays.sort` will use this method, even though it doesn't implement the Comparator interface.

3. In `TaskTimer`, write an anonymous class as value of `task1` instead of using the GarbageCollector class. (**TODO 3**)

4. In `TaskTimer`, write a method reference as value of `task2`, so that the task directly refers to `System.gc()`. (**TODO 4**)

5. In `HelloFX.java`, **replace** the `GreetHandler` inner class with a **method** named `handleGreetAction`.  The new method does exactly the same thing as `GreetHandler`.  Then write a **method reference** for the button event handler that refers to `handleGreetAction`.
   * When you are done, there should **not** be an inner class.  It is replaced by the `handleGreetAction` method.

```java
   // this method replaces the GreetHandler.handle method
   private void handleGreetAction(ActionEvent event) {
       handle button press
   }
```

### Anonymous Class

Anonymous classes are used a lot in code where you only want to create one instance of a class, and the code is short.

Slides: [Anonymous Classes](https://skeoop.github.io/java-intermed/Anonymous-Class.pdf)

### Method Reference

Method Reference is a syntax for creating a reference to a method.  
You can use a method reference as value of a parameter for something that expects a interface reference, like the Comparator in `Arrays.sort(array, Comparator)`.

It is used a lot for references to interfaces that have only one abstract method (called "functional interfaces").  You can use an ordinary method in place of a class that implements the interface.


The Event Handlers in JavaFX are a good example.  Using a method reference, you can write event handlers in your class as ordinary methods instead of creating inner classes.  And they are simple to refer to!

[Intro to Method References](https://skeoop.github.io/java8/Method-References)
