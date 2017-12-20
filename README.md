# WFuzz

## Install

''pip install wfuzz''

## Tutorial

### Part 1 : Overview

Using : 
* payload : file : fuzzfile/part1-1.txt
* url : localhost:8080

Execution :
'wfuzz -c -z file,fuzzfile/part1-1.txt http://localhost:8080/FUZZ'

Command details:
* -c : add color to result
* -z : specify payload : file,fuzzfile/part1-1.txt
* url : url to use
* FUZZ : pattern to replace

Serveur log :
'
'

Easy to protect agains certain user agents like PyCURL : _add PyCURL on HTTP request ignore list__
WFuzz allow to alter user agent with **-H** option :
'wfuzz -c -z file,fuzzfile/part1-1.txt -H "User-Agent: Mozilla" http://localhost:8080/FUZZ'

The new Server log :
'
'

Using second pattern : 
**Use two files**

* payload : file : fuzzfile/part1-1.txt fuzzfile/part1-2.txt

Execution :
'wfuzz -c -z file,fuzzfile/part1-1.txt -z file,fuzzfile/part1-2.txt http://localhost:8080/FUZZ/FUZ2Z'

Use _FUZxZ_ for specify other patterns with x the pattern number. One pattern by file.

Ignore useless results it's possible (for example 404 errors) :
* use the **--hc** (for hide code) and the statut code : 'wfuzz -c -z file, fuzzfile/part1-1.txt --hc 404 http://localhost:8080/FUZZ'
* use the **--hs** (h for hide and s for regex) and the pattern : 'wfuzz -c -z file, fuzzfile/part1-1.txt --hs incorrect http://localhost:8080/FUZZ'

### Part 2 : Know what accessible resources with recursive execution

### Other : help

* help : 'wfuzz -h'
* List of available payloads : 'wfuzz -e payload'
* List of available encodings : 'wfuzz -e encoders'