# WFuzz

## Install

'''pip install wfuzz'''

## Tutorial

### Part 1 : Utilisation

Using : 
* playload : file : fuzzfile/part1-1.txt
* url : localhost:8080

Execution :
'''wfuzz -c -z file,fuzzfile/part1-1.txt http://localhost:8080/FUZZ

Command details:
* -c : add color to result
* -z : specify playload : file,fuzzfile/part1-1.txt
* url : url to use
* FUZZ : pattern to replace

Serveur log :
'''
'''

Using second pattern : 
**Use two files**

* playload : file : fuzzfile/part1-1.txt fuzzfile/part1-2.txt

Execution :
'''wfuzz -c -z file,fuzzfile/part1-1.txt -z file,fuzzfile/part1-2.txt http://localhost:8080/FUZZ/FUZ2Z'''

Use _FUZxZ_ for specify other patterns with x the pattern number. One pattern by file.