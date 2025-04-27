
# Overview:

This project reads a set of coordinates from a file and computes the shortest path connecting all points, using a local search algorithm to approximate a solution to the Traveling Salesman Problem (TSP). The calculated path is printed in the console, showing the order of points visited and the total cost. Additionally, a graphical window is launched to visually display the points and the resulting shortest path connecting them.

# Features:

- Utilizes TSP local search to quickly ascertain the shortest path from point to point without visiting one more than once.
- Provides an easy-to-read graphical display of the solution.
- Alternatively also provides a text-based display of the solution.
  
# Usage:

The source code should be placed in an src file, where the src file is nested in an outer project file. Place the coordinate point files in the outer project file.
When the program starts, you will be prompted for the name of the file containing the coordinate points. Input NAME_OF_FILE.txt.
