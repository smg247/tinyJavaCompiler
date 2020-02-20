# Tiny Java Compiler
### What is it?
Using [CUP](http://www2.cs.tum.edu/projects/cup/index.php) and [jFlex](https://jflex.de/manual.html)
this program scans and parses an input file in the TinyJava language. It will report any syntax errors in the program to
the supplied output file.

### Usage
Use maven to install the program ```mvn clean install```  
Run the compile script pointing to your input file and output log file ```./compile.sh input.java output.log```  
The program will run silently and report any errors to the supplied output file. If there are no errors the output file
will be empty. 