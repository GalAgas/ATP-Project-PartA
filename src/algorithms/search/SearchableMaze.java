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

        allStates = new ArrayList<AState>();

        //creates all states with zero
        buildAllStates();

        //initializes 4 neigbours for each state and set start & goal
        setNeigbours();

        int sRow = maze.getStartPosition().getRowIndex();
        int sCol = maze.getStartPosition().getColumnIndex();
        start = searchStateByName(sRow, sCol);

        int gRow = maze.getGoalPosition().getRowIndex();
        int gCol = maze.getGoalPosition().getColumnIndex();
        goal = searchStateByName(gRow, gCol);

    }


    public AState up (AState state)
    {
        int row = getRowState(state);
        int col = getColState(state);
        AState up = null;
        if (row-1 >= 0 && maze.isZero(row-1, col))
            up = searchStateByName(row-1, col);
        return up;
    }

    public AState right (AState state)
    {
        int row = getRowState(state);
        int col = getColState(state);
        AState right = null;
        if (col+1 <= maze.getCols()-1 && maze.isZero(row, col+1))
            right = searchStateByName(row, col+1);
        return right;
    }

    public AState left (AState state)
    {
        int row = getRowState(state);
        int col = getColState(state);
        AState left = null;
        if (col-1 >= 0 && maze.isZero(row, col-1))
            left = searchStateByName(row, col-1);
        return left;
    }

    public AState down (AState state)
    {
        int row = getRowState(state);
        int col = getColState(state);
        AState down = null;
        if (row+1 <= maze.getRows()-1 && maze.isZero(row+1, col))
            down = searchStateByName(row+1, col);
        return down;
    }


    private void buildAllStates()
    {
        for (int i=0; i<maze.getRows(); i++) {
            for (int j = 0; j < maze.getCols(); j++) {
                if (maze.isZero(i, j)) {
                    AState newState = new MazeState(Integer.toString(i) + "," + Integer.toString(j));
                    allStates.add(newState);
                }
            }
        }
    }

    private void setNeigbours()
    {
        for (AState state : allStates) {
            state.getNeigbours()[0] = up(state);
            state.getNeigbours()[1] = right(state);
            state.getNeigbours()[2] = down(state);
            state.getNeigbours()[3] = left(state);
        }
    }

    private int getRowState(AState state)
    {
        int index = state.getName().indexOf(",");
        int row = Integer.parseInt(state.getName().substring(0,index));
        return row;
    }

    private int getColState(AState state)
    {
        int index = state.getName().indexOf(",");
        int col = Integer.parseInt(state.getName().substring(index+1));
        return col;
    }

    private AState searchStateByName(int row, int col)
    {
        AState found = null;
        for (int i=0; i<allStates.size(); i++)
        {
           if (getRowState(allStates.get(i)) == row && getColState(allStates.get(i)) == col)
               found = allStates.get(i);
        }
        return found;
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

    public AState getStart() { return start; }

    public AState getGoal() { return goal; }

}
