package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int cols)
    {
        if (rows<3)
            rows=3;
        if (cols<3)
            cols=3;
        Maze emptyMaze = new Maze(rows, cols);
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
                emptyMaze.getMaze()[i][j] = 0;
        }
        chooseStartandGoal(emptyMaze, rows, cols);
        return emptyMaze;
    }
}
