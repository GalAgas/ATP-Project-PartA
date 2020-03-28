package algorithms.mazeGenerators;

import java.util.concurrent.ThreadLocalRandom;

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

        //selects a random side of the frame - up, down, right or left for the start.
        int frameSideStart = ThreadLocalRandom.current().nextInt(0, 4);
        int startRandomCol = ThreadLocalRandom.current().nextInt(0, cols);
        int startRandomRow = ThreadLocalRandom.current().nextInt(0, rows);
        boolean startInCorner = false;


        int frameSideGoal;
        int goalRandomCol = ThreadLocalRandom.current().nextInt(0, cols);
        int goalRandomRow = ThreadLocalRandom.current().nextInt(0, rows);


        //up side
        if (frameSideStart == 0)
        {
            emptyMaze.setStartPosition(0, startRandomCol);

            //up right corner-goal can be in left or down only
            if (startRandomCol == cols - 1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                    emptyMaze.setGoalPosition(goalRandomRow,0);
                else //down
                    emptyMaze.setGoalPosition(rows-1, goalRandomCol);
            }

            //up left corner-goal can be in right or down only
            else if(startRandomCol == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                    emptyMaze.setGoalPosition(goalRandomRow,cols-1);
                else //down
                    emptyMaze.setGoalPosition(rows-1, goalRandomCol);
            }
        }

        //down side
        else if (frameSideStart == 3)
        {
            emptyMaze.setStartPosition(rows-1, startRandomCol);

            //down right corner-goal can be in left or up only
            if (startRandomCol == cols - 1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                    emptyMaze.setGoalPosition(goalRandomRow,0);
                else //up
                    emptyMaze.setGoalPosition(0, goalRandomCol);
            }

            //down left corner-goal can be in right or up only
            else if(startRandomCol == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                    emptyMaze.setGoalPosition(goalRandomRow,cols-1);
                else //up
                    emptyMaze.setGoalPosition(0, goalRandomCol);
            }
        }

        //left side
        else if (frameSideStart == 2)
        {
            emptyMaze.setStartPosition(startRandomRow, 0);
        }

        //right side
        else
        {
            emptyMaze.setStartPosition(startRandomRow, cols-1);
        }

        //start is not in the corner-goal can be in right, left or down
        if (!startInCorner)
        {
            frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
            if (frameSideGoal == 0)//right
                emptyMaze.setGoalPosition(goalRandomRow,cols-1);
            else if (frameSideGoal == 1) //left
                emptyMaze.setGoalPosition(goalRandomRow,0);
            else //down
                emptyMaze.setGoalPosition(rows-1,goalRandomCol);
        }

        return emptyMaze;
    }
}
