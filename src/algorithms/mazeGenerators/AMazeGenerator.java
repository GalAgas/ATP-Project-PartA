package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator
{
    public long measureAlgorithmTimeMillis(int rows, int cols)
    {
        long startTime = System.currentTimeMillis();
        this.generate(rows, cols);
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }


}
