## Time

Write a `Time` class.  `Time` represents a duration of time with 1-second precision.
`Time` has methods for getting the hours, minutes, and seconds, and for adding Times.

1. Write good code using the Java Coding Standard.
2. Include Javadoc, especially class Javadoc with `@author` tag.
3. You may use the method descriptions in the table below in your javadoc, but add `@param`, `@return` where appropriate.
4. Integer arithmetic:
    ```
    59/60 is 0
    59%60 is 59  (59 mod 60)
    655/60 is 10
    655%60 is 55
    50%10 is 0  (50 mod 10)
    (247/10)%10 is 4 
    ```
5. String formatting:
    ```java
    String.format("%d:%02d:%02d", 10, 8, 6) is "10:08:06"
    // "%02d" means 2 digit integer with "0" padding if needed
    String.format("%03d", 7) returns "007"
    ```

### Starter Code

`Main.java` - some code to test your Time class.  It has a method for interactive use and another method to create and print some times without interaction.

### Time API

<table border="1" width="100%">
<tr valign="top">
<td>
Time( int seconds )
</td>
<td>
Constructor for a Time object. seconds is the time in seconds, can be any non-negative value.
</td>
</tr>
<tr valign="top">
<td>
Time(int hours, int minutes, int seconds)
</td>
<td>
Constructor for a Time object.  The hours, minutes, and seconds can have any non-negative value, even bizarre values like
new Time(1,60,80) or Time(0,0,7280)
</td>
</tr>
<tr valign="top">
<td>
int getHours()
</td>
<td>
Returns the time in hours, as an integer.
</td>
</tr>
<tr valign="top">
<td>
int getMinutes()
</td>
<td>
Returns the time in minutes, after removing any hours.  Value is always 0 - 59.
</td>
</tr>
<tr valign="top">
<td>
int getSeconds()
</td>
<td>
Returns the time in seconds, after removing any hours and minutes. Value is always 0 - 59.
</td>
</tr>
<tr valign="top">
<td>
Time add( Time time )
</td>
<td>
Add another Time to this Time and returns the total as a new Time object. Does not modify this Time object.
</td>
</tr>
<tr valign="top">
<td>
boolean equals(Object other)
</td>
<td>
Returns true if other is a Time object and both have the same value.
</td>
</tr>
<tr valign="top">
<td>
String toString()
</td>
<td>
Return a String representation of time in the format h:mm:ss.  mm and ss are always 2 digits, such as 1:00:09 (1 hour, 0 minutes, 9 seconds) or 0:00:30.
</td>
</tr>
