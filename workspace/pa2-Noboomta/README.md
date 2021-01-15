# Encryption-Decryption Application

Write a description of what your program does.

Mention any special features, such as encrypting Thai.

Details of assignment are at https://skeoop.github.io/assignments/PA2-Encryption

The [Hyperskill](https://hyperskill.org) project that has step-by-step instructions and exercises for this application is [https://hyperskill.org/projects/46?goal=7](https://hyperskill.org/projects/46?goal=7)

## Usage

How to run the program.
java Crypt -mode ("enc"/"dec") -alg ("shift"/"unicode") -key (int key) -data (String Data) -in (input file) -out (output file)

1) mode, mode to crypt.
    - enc: encrypt is to increase key into every char to be the new char.
    - dec:  decrypt is to decrease key into every char to be the new char.

2) alg, algorithm of the crypt process.
    - shift:    only Alphabet will be crypt.
    - unicode:  all the char in String will be crypt.

3) key, int number to be add or minus every char in the crypt process.

4) data, String that need to crypt.

5) in, input file (.txt).

6) out, output file (.txt).