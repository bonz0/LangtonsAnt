Langton's Ant:

Langton's Ant is essentially a Turing machine invented by Chris Langton in 1986.
The machine consists of:
- A grid of cells; each cell can have one of two colors: black or white.
- An ant; this ant moves on the grid based on certain rules and it changes the grid as it moves.

The ant moves according to the following rules:
- If the ant is on a white cell, it turns right and moves one step forward
- If the ant is on a black cell, it turns left and moves one step forward
- Any time the ant moves from one cell to another, it changes the color of the previous cell

The interesting part:  
As one would expect, if you run multiple iterations of the movement of the ant, at first glance
it seems like the movement of the ant is 'random'. But after some number of iterations the ant
starts to follow a fixed pattern and it continues to do so till infinity.

More information: https://en.wikipedia.org/wiki/Langton%27s_ant
