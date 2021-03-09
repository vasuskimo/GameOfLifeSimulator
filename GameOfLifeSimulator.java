import java.util.Scanner;

public class GameOfLifeSimulator
{
    int[][] grid;
    int generation;
    int side;

    GameOfLifeSimulator(int side)
    {
        this.side = side;
        this.grid = new int[side][side];

        // Glider pattern in the middle of the cell universe
        // =================================================
        int start = Math.round(side/2);
        this.grid[start-2][start] = 1;
        this.grid[start-3][start-1] = 1;
        this.grid[start-1][start-2] = 1;
        this.grid[start-1][start-1] = 1;
        this.grid[start-1][start] = 1;
        this.generation = 1;
    }

    public void printGrid()
    {
        for (int i = 0; i < side; i++)
        {
            for (int j = 0; j < side; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }


    public int countLiveNeighbors(int x, int y)
    {
        int count = 0;

        // Get the state of all its eight neighbors
        // ========================================
        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y)
    {
        // is it outside the grid?
        // =======================
        if (x < 0 || x >= side || y < 0 || y >= side)
            return 0;
        return this.grid[x][y];
    }

    public void advance()
    {
        int[][] transitions = new int[side][side];
        generation++;

        // goto each cell in the grid
        // ==========================
        for (int y = 0; y < side; y++)
        {
            for (int x = 0; x < side; x++)
            {
                int liveNeighbors = countLiveNeighbors(x, y);

                if (getState(x, y) == 1)
                {
                    if (liveNeighbors < 2)
                        transitions[x][y] = 0;
                    else if (liveNeighbors == 2 || liveNeighbors == 3)
                        transitions[x][y] = 1;
                    else if (liveNeighbors > 3)
                        transitions[x][y] = 0;
                }
                else
                {
                    if (liveNeighbors == 3)
                        transitions[x][y] = 1;
                }
            }
        }

        System.out.println("Generation " + generation);
        this.grid = transitions;
        printGrid();
    }


    public void simulate()
    {
        System.out.println("Generation 1");
        printGrid();
        System.out.println();
        advance();
        Scanner scan= new Scanner(System.in);
        while(true)
        {
            String response= scan.nextLine();
            if(response.equals("quit"))
                break;
            advance();
        }
    }

    public static void main(String[] args)
    {
        int side = 25;
        GameOfLifeSimulator gol = new GameOfLifeSimulator(side);
        gol.simulate();
    }
}
