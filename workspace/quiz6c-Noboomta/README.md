## Problem Description 

Read a list of expenses (including currencies) from a file, 
one item per line,
and compute the totals for each currency in the file.

Then, print the totals **sorted by currency**.

Each line in the input file is either an empty line 
or one expense item like this:
```
245.80 Dollars    optional description of this item
    75 Baht       coffee at Starbucks
890 Dollars       purchase final exam on EBay

199.95 Ruples       
255 Baht          dinner from Pizza Shoppe
```
Notice the blank line and spaces at start of second line. That is OK.    
After the amount and currency, anything else on the line should be ignored.

Your code should compute the totals by currency using a Map.
Ignore the optional description of each expense item.

Print the sums by **sorted by currency** and nicely format output. For the above example data:
```
  320.00  Baht
1,234.80  Dollars
  199.95  Ruples
```

### Requirements

1. Put all code in one class named `Main.java`.
2. Write a method to read data from the input, put key-values in map, return the map (you decide what the keys and values are).
3. Write a method to print the expense totals using the map, sorted by currency.
4. Use a command line argument as name of the file to read.  If the file cannot be opened then print "Cannot read file xxx" and exit.

Use a **Map** to hold currencies and totals, and write efficient code.  
Points deducted for unnecessary, inefficient code.

### Programming Hints

1. Sorting of keys is automatic if you use the correct Map class!
2. The `printf` formats for integer and floating point allow you to specify "," before the field size to request that locale-specific number groupings be inserted in values, e.g. "%,5d" for 12,345 or "%,6.1f" for 12,345.0.
3. If you use Scanner to read the data, note that the current location of Scanner is always the character after the last thing returned by the scanner, which may be the `\n` character. `nextLine()` returns the remainder of the *current* line, even if it is empty.  This behavior of nextLine() can be used to discard extra data on a line.  There are also other ways to do this, without using a Scanner.


## Example

The file `expenses.txt` contains sample input data.
