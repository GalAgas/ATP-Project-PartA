package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazeGenerator
{
    @Override
    public Maze generate(int rows, int cols) {
        Maze simpleMaze = new Maze(rows, cols);
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
                simpleMaze.getMaze()[i][j] = '0';
        }
        chooseStartandGoal(simpleMaze, rows, cols);
        return simpleMaze;
    }
}
