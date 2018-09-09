# SimpleCompiler

This program can make HOO file to C file

HOO is no exist computer language.
It is a fictional computer language in my mind.

-------------------------------------------------------------
## HOO rules
-------------------------------------------------------------
[...] - 'String' or 'String function'
: - 'A separator between part of string and part of command'
('natural number') - 'Number of repetitions of String'
/ - 'A symbol of char replacement'
print - 'A keyword for printing string'
ignore - 'A keyword for ignoring string'


-------------------------------------------------------------
## HOO examples             Output
-------------------------------------------------------------
[bbb] : print               >> bbb
[bbb] [U] : print           >> BBB (Change to upper case)
[AAB] [L] : print           >> aab (Change to lower case)
[bbb] : ignore              >> 
[] : print                  >> "" (new line)
[HI] : (3) print            >> HIHIHI

[bbb] :
[aaa] : print               >> bbbaaa

[bbc] [b/a] : print         >> aac (Change 'b' to 'a')
