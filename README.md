
# About

This is a (very) small project related to chess programming to help visualize how [magic numbers](https://www.chessprogramming.org/Magic_Bitboards) for a particular board positions might work.

There are two parts to this :
* The Java data generator.
* The HTML + js editor.

For a particular bitmask x<sub>0</sub>...x<sub>63</sub> where x<sub>n</sub> represents the presence or absence of a piece at the given position, and a magic number m<sub>0</sub>...m<sub>63</sub>, the generator basically lays out their [long multiplication](https://en.wikipedia.org/wiki/Multiplication_algorithm#Long_multiplication) table. Right now it's only for Rooks.

The table can be viewed on any spreadsheet editor. That brings us to the other part. 

The visualizer/editor is supposed use the spreadsheet, represent the multiplication table and help us understand how changing a particular bit at a given position might effect the overall mapping of results. The visualizer is still work in progress and will eventually be checked in to this public repo.

Note on sheet names: The sheet names are indexes for a piece in a bit board with [LERBEF](https://www.chessprogramming.org/Bibob) layout.
