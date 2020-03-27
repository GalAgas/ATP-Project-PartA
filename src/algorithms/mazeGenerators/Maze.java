package algorithms.mazeGenerators;

public class Maze
{
    private int rows;
    private int cols;
    private char[][] maze;
    private Position startPosition;
    private Position goalPosition;

    public Maze(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        maze = new char[rows][cols];
    }

    public char[][] getMaze()
    {
        return maze;
    }

    /*public void setMaze(char[][] maze)
    {
        this.maze = maze;
    }
    */

    public Position getStartPosition()
    {
        return startPosition;
    }

    public Position getGoalPosition()
    {
        return goalPosition;
    }
}
