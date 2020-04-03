package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable
{
    private Maze maze;
    private AState start;
    private AState goal;

    public SearchableMaze(Maze maze)
    {
        this.maze = maze;
        int Srow = maze.getStartPosition().getRowIndex();
        int Scol = maze.getStartPosition().getColumnIndex();
        start = new MazeState(Integer.toString(Srow)+Integer.toString((Scol)));

        int Grow = maze.getGoalPosition().getRowIndex();
        int Gcol = maze.getGoalPosition().getColumnIndex();
        goal = new MazeState(Integer.toString(Grow)+Integer.toString(Gcol));

    }


    public AState up (AState state)
    {
        int row = Integer.valueOf(state.getName().charAt(0));
        int col = Integer.valueOf(state.getName().charAt(1));
        MazeState up = null;
        if (row-1 >= 0 && maze.isZero(row-1, col))
            up = new MazeState(Integer.toString(row - 1)+Integer.toString(col));
        return up;
    }

    public AState right (AState state)
    {
        int row = Integer.valueOf(state.getName().charAt(0));
        int col = Integer.valueOf(state.getName().charAt(1));
        MazeState right = null;
        if (col+1 <= maze.getCols()-1 && maze.isZero(row, col+1))
            right = new MazeState(Integer.toString(row)+Integer.toString(col+1));
        return right;
    }

    public AState left (AState state)
    {
        int row = Integer.valueOf(state.getName().charAt(0));
        int col = Integer.valueOf(state.getName().charAt(1));
        MazeState left = null;
        if (col-1 >= 0 && maze.isZero(row, col-1))
            left = new MazeState(Integer.toString(row)+Integer.toString(col-1));
        return left;
    }

    public AState down (AState state)
    {
        int row = Integer.valueOf(state.getName().charAt(0));
        int col = Integer.valueOf(state.getName().charAt(1));
        MazeState down = null;
        if (row+1 <= maze.getRows()-1 && maze.isZero(row+1, col))
            down = new MazeState(Integer.toString(row + 1)+Integer.toString(col));
        return down;
    }


    @Override
    public ArrayList<AState> getAllPossibleStates(AState state)
    {
        ArrayList<AState> possibleS = new ArrayList<AState>();

        AState up = up(state);
        AState right = right(state);
        AState left = left(state);
        AState down = down(state);

        boolean upRight = false;
        boolean upLeft = false;
        boolean downRight = false;
        boolean downLeft = false;

        if (up != null)
        {
            possibleS.add(up);
            AState upR = right(up);
            if (upR != null)
            {
                upRight = true;
                possibleS.add(upR);
            }
        }

        if (right != null)
        {
            possibleS.add(right);
            if (!upRight)
            {

            }
        }

        if (left != null)
        {
            possibleS.add(left);
        }

        if (down != null)
        {
            possibleS.add(down);
        }



        return possibleS;
    }

    public AState getStart()
    {
        return start;
    }

    public AState getGoal()
    {
        return goal;
    }

}
