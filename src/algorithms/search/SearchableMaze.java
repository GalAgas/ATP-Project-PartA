package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable
{
    private Maze maze;
    private AState start;
    private AState goal;
    private ArrayList<AState> allStates;


    public SearchableMaze(Maze maze)
    {
        this.maze = maze;
        int Srow = maze.getStartPosition().getRowIndex();
        int Scol = maze.getStartPosition().getColumnIndex();

        int Grow = maze.getGoalPosition().getRowIndex();
        int Gcol = maze.getGoalPosition().getColumnIndex();

        allStates = new ArrayList<AState>();
        for (int i=0; i<maze.getRows(); i++)
        {
            for (int j=0; j<maze.getCols(); j++)
            {
                if(maze.isZero(i,j))
                {
                    AState newState = new MazeState(Integer.toString(i)+Integer.toString(j));
                    allStates.add(newState);

                    newState.getNeigbours()[0] = up(newState);
                    newState.getNeigbours()[1] = right(newState);
                    newState.getNeigbours()[2] = down(newState);
                    newState.getNeigbours()[3] = left(newState);

                    if (i == Srow && j == Scol)
                        start = newState;

                    if (i == Grow && j == Gcol)
                        goal =newState;
                }
            }
        }
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

        AState upR = null;
        AState upL = null;
        AState downR = null;
        AState downL = null;


        //up
        if (state.getNeigbours()[0] != null)
        {
            possibleS.add(state.getNeigbours()[0]);
            upR = state.getNeigbours()[0].getNeigbours()[1];
            if (upR != null)
                possibleS.add(upR);
            upL = state.getNeigbours()[0].getNeigbours()[3];
            if (upL != null)
                possibleS.add(upL);
        }

        //right
        if (state.getNeigbours()[1] != null)
        {
            possibleS.add(state.getNeigbours()[1]);
            if (upR == null)
            {
                upR = state.getNeigbours()[1].getNeigbours()[0];
                if (upR != null)
                    possibleS.add(upR);
            }
            downR = state.getNeigbours()[1].getNeigbours()[2];
            if (downR != null)
                possibleS.add(downR);
        }

        //down
        if (state.getNeigbours()[2] != null)
        {
            possibleS.add(state.getNeigbours()[2]);
            if (downR == null)
            {
                downR = state.getNeigbours()[2].getNeigbours()[1];
                if (downR != null)
                    possibleS.add(downR);
            }
            downL = state.getNeigbours()[2].getNeigbours()[3];
            if (downL != null)
                possibleS.add(downL);
        }

        //left
        if (state.getNeigbours()[3] != null)
        {
            possibleS.add(state.getNeigbours()[3]);
            if (upL == null)
            {
                upL = state.getNeigbours()[3].getNeigbours()[0];
                if (upL != null)
                    possibleS.add(upL);
            }
            if (downL == null)
            {
                downL = state.getNeigbours()[3].getNeigbours()[2];
                if (downL != null)
                    possibleS.add(downL);
            }
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
