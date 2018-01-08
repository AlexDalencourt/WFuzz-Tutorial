# WFuzz

## Install

`pip install wfuzz`

## Tutorial

### Part 1 : Overview

Using : 
* payload : file : fuzzfile/part1-1.txt
* url : localhost:8080

Execution :
```wfuzz -c -z file,fuzzfile/part1-1.txt http://localhost:8080/FUZZ```

Command details:
* -c : add color to result
* -z : specify payload : file,fuzzfile/part1-1.txt
* url : url to use
* FUZZ : pattern to replace

Serveur log :
```
[06/Jan/2018:17:12:50 +0100] 0:0:0:0:0:0:0:1 "GET /marvin HTTP/1.1" Wfuzz/2.2.8 404 (8 ms)
[06/Jan/2018:17:12:50 +0100] 0:0:0:0:0:0:0:1 "GET /filelist HTTP/1.1" Wfuzz/2.2.8 404 (4 ms)
[06/Jan/2018:17:12:50 +0100] 0:0:0:0:0:0:0:1 "GET /ford HTTP/1.1" Wfuzz/2.2.8 404 (9 ms)
[06/Jan/2018:17:12:50 +0100] 0:0:0:0:0:0:0:1 "GET /description HTTP/1.1" Wfuzz/2.2.8 404 (7 ms)
[06/Jan/2018:17:12:50 +0100] 0:0:0:0:0:0:0:1 "GET /filesList HTTP/1.1" Wfuzz/2.2.8 404 (21 ms)
```

Easy to protect agains certain user agents like Wfuzz : _add Wfuzz on HTTP request ignore list_
WFuzz allow to alter user agent with **-H** option :
```wfuzz -c -z file,fuzzfile/part1-1.txt -H "User-Agent: Mozilla" http://localhost:8080/FUZZ```

The new Server log :
```
[06/Jan/2018:17:20:19 +0100] 0:0:0:0:0:0:0:1 "GET /h2g2 HTTP/1.1" Mozilla 404 (13 ms)
[06/Jan/2018:17:20:19 +0100] 0:0:0:0:0:0:0:1 "GET /arthur HTTP/1.1" Mozilla 404 (3 ms)
[06/Jan/2018:17:20:19 +0100] 0:0:0:0:0:0:0:1 "GET /marvin HTTP/1.1" Mozilla 404 (4 ms)
[06/Jan/2018:17:20:19 +0100] 0:0:0:0:0:0:0:1 "GET /ford HTTP/1.1" Mozilla 404 (3 ms)
[06/Jan/2018:17:20:19 +0100] 0:0:0:0:0:0:0:1 "GET /description HTTP/1.1" Mozilla 404 (5 ms)
```

Using second pattern : 
**Use two files**

* payload : file : fuzzfile/part1-1.txt fuzzfile/part1-2.txt

Execution :
```wfuzz -c -z file,fuzzfile/part1-1.txt -z file,fuzzfile/part1-2.txt http://localhost:8080/FUZZ/FUZ2Z```

Use _FUZxZ_ for specify other patterns with x the pattern number. One pattern by file.

Ignore useless results it's possible (for example 404 errors) :
* use the **--hc** (for hide code) and the statut code : `wfuzz -c -z file, fuzzfile/part1-1.txt --hc 404 http://localhost:8080/FUZZ`
* use the **--hs** (h for hide and s for regex) and the pattern : `wfuzz -c -z file, fuzzfile/part1-1.txt --hs incorrect http://localhost:8080/FUZZ`

It is possible to send a POST request (or other http request) with the parameter **-d**. We will try to connect to our application with fuzz
```wfuzz -c -z file,fuzzfile/part1-1.txt -z file,fuzzfile/part1-2.txt -d "login=FUZZ&pwd=FUZ2Z" http://localhost:8080/login```
**-X method** is for other HTTP methods.

It is possible to specify HTTP heard with **-H "header=test&header2=FUZZ"**

### Part 2 : Know what accessible resources with recursive execution

By default, Wfuzz operate from the first repertory level.

Wfuzz can be recursive when a valid path is found with the following option : **-R number_of_level**

For example ```wfuzz -c -z file,fuzzfile/part2-1.txt -R 2 http://localhost:8080/FUZZ```

### Part 3 : Know what accessible resources with encode execution

There is many payloads types. They can be show with :
```
wfuzz -e payloads
```

There is the possibility to use free list of values. On our application we now that we store files and there are references to h2g2. Try this payload : names

```
wfuzz -c -z names,h2g2-jpeg http://localhost:8080/files/FUZZ
```

The last thing that we will present here is the possibility to encore our payloads.
All encoding algorithme available for wfuzz can be show with this command : ```wfuzz -e encoders```
Now we will try to test a connection request with encoding passwords:
```
wfuzz -c -z file,fuzzfile/part3-1.txt -z file,fuzzfile/part3-2.txt,md5 -d "login=FUZZ&pwd=FUZ2Z" http://localhost:8080/login
```

### Part 4 : Generate a report

It is possible to generate an HTML report of wfuzz execution.
We need to use **-o HTML**
Try this:
```
wfuzz -c -o HTML -z file,fuzzfile/part3-1.txt -z file,fuzzfile/part3-2.txt,md5 -d "login=FUZZ&pwd=FUZ2Z" http://localhost:8080/login
```

### Other : help

* help : `wfuzz --help`
* List of available payloads : `wfuzz -e payload`
* List of available encodings : `wfuzz -e encoders`
