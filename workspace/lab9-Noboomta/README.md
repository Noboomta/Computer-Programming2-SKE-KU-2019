## File Copy Application

Record the time to copy files using FileCopy, using a small text file and a multi-megabyte binary file (MP3, JPEG, PNG, etc).

Record the times for copying one byte at a time (problem 1) and using an array as buffer (problem 2).

#Problem 1 

| File | time(sec) |    bytes         |
:------|-----------|------------------:
| txt  | 0.010383  | 341 bytes        |
| jpg  | 0.0337092 | 2,101,546 bytes  |
| png  | 0.1632052 | 10,473,459 bytes |
| mp3  | 0.1288225 | 2967 bytes       |

#Problem 2

|    bytes    | File | time(sec) |    bytes    |
:-------------|------|-----------|-------------:
|    1024     | txt  | 0.0019645 |  341 bytes  |
|    2048     | txt  | 0.0021698 |  341 bytes  |
|    4096     | txt  | 0.0037769 |  341 bytes  |
|    8192     | txt  | 0.0019628 |  341 bytes  |

|    bytes    | File | time(sec) |    bytes    |
:-------------|------|-----------|-------------:
|    1024     | png  | 0.005796  | 42965 bytes |
|    2048     | png  | 0.0025756 | 42965 bytes |
|    4096     | png  | 0.0032669 | 42965 bytes |
|    8192     | png  | 0.0020268 | 42965 bytes |
