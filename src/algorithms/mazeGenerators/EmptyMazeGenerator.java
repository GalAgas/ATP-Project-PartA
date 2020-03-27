package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int cols)
    {
        Maze emptyMaze = new Maze(rows, cols);
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
                emptyMaze.getMaze()[i][j] = '0';
        }

        // need to set start and end
        return emptyMaze;
    }
}
