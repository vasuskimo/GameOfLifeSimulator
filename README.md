# Game Of Life Simulator

## Game of Life Definition
The universe of the Game of Life is an infinite two­dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead. Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent.

## Rules:

At each step in time, the following transitions occur:
1. Any live cell with fewer than two live neighbours dies, as if caused by under­population.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overcrowding.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick (in other words, each generation is a pure function of the preceding one). The rules continue to be applied repeatedly to create further generations.

Note: A ‘Glider’ pattern is placed in the middle of 25x25 cell universe during the start.


## Build
To build type the command javac GameOfLifeSimulator.java in your console

## Run
To run type the command java GameOfLifeSimulator in your console

## Advance
To advance the simulation, simply press the Enter key

## Quit
To quit the simulation, type quit
