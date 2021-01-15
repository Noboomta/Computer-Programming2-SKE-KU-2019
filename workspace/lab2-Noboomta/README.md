# Stopwatch Tasks 

by Puvana Swatvanit

I ran the tasks on ASUS with CPU Intel core I7 gen 9 and got these results:

Task                                      | Time
------------------------------------------|-------:
Sum 10,000,000 double primitives          | 0.029421 sec
Sum 10,000,000 Double objects             | 0.131860 sec
Sum 10,000,000 BigDecimal objects         | 0.150305 sec
Length of the String from 65-65000        | 0.574270 sec
Length of the StringBuilder from 65-65000 | 0.003399 sec
Sum in range 65000 using 2 loop           | 4.284721 sec

## Explanation of Results

Task 1 is faster than Task 2 because Object have a higher bytes, also longer time.

Task 3 is slower than tasks 1 and 2 because The BigDecimal is bigger storage than both of Task1 and 2.

Task 4 need to long times to run, because of when create the string it sonsume thew memory each time it's create

Task 5 unlike the Task 4 Stringbuilder will consume less memory than String when it create that's why it's faster than Task 4

Task 6, I did the 65000*65000 time loop to see how long does it, and I found that it took more than 4 second!! to run them.
ps. 65000*65000 is nearly 4_225_000_000 time loop.


